# Dijkstra's Shortest Path Algorithm
**Given a graph, and a source vertex, find shortest distances from source to all other vertices.**

### pros
 - works for
    - cyclic & acyclic
    - weighted & non-weighted
    - directed & undirected
 
### cons
 - does not work for negative weighted edges.
 
## Idea behind the Algorithm
 - We maintain an Array of distance for all vertices initialized with values Infinite.
 - distance of source is 0
 - At each iteration, we pick a vertex and finalize it distance. Initially no vertex is finalized.
 - *How do we pick the vertex ?*
    - we pick the vertex from the set, which has minimum distance
 - then we go to all adjacent vertices of it, and check whether do we get a shorter path to that vertex, through current vertex, If yes. then we update it's distance
 
## pseudo code
```
Dijkstra(graph, s):
    Create an empty Priority Queue (Min Heap), pq
    Intialize distance[v] = {INF, INF, INF, INF, INF,........}
    distance[s] = 0
    Insert (s, distance[s]) Priority Queue pq                        // O(V) time
    while pq is not empty:                                           // loop runs V times
          u = pq.extractMin( )                                       // O(log V) time, overall time O(Vlog V) time
          for (all v: adjacent of u):
                if (distance[v] > distance[u] + weight(u, v)):
                      distance[v] = distance[u] + weight(u, v)       // overall time O(Elog V)
                                  
                                                                     // overall Time Complexity: O(Vlog V + Elog V)
```

## code
```java
import java.io.*;
import java.util.*;

class Pair implements Comparable <Pair> {

	int x;
	long y;

	Pair (int x, long y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo (Pair pair) {
		return (int) (this.y - pair.y);
	}
}

class Graph {

	int v;
	ArrayList<ArrayList<Pair>> graph;

	Graph (int v) {
		this.v = v;
		this.graph = new ArrayList<ArrayList<Pair>>();
		for (int i=0; i<v; i++) {
			graph.add(new ArrayList<Pair>());
		}
	}

	void addEdge (int src, int dst, long weight) {
		graph.get(src).add(new Pair(dst, weight));
		graph.get(dst).add(new Pair(src, weight));
	}

	void dijkstra (int src) {
		long[] distance = new long[v];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[src] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.add(new Pair(src, 0));
		while (!pq.isEmpty()) {
			Pair curr = pq.poll();
			for (Pair adj: graph.get(curr.x)) {
				if (distance[adj.x] > distance[curr.x] + adj.y) {
					distance[adj.x] = distance[curr.x] + adj.y;
					pq.add(new Pair(adj.x, distance[adj.x]));
				}
			}
		}
		for (int i=0; i<v; i++) {
			System.out.println("Shortest Distance from "+src+" to "+i+" is: "+distance[i]);
		}
	}
}

class Main {

	public static void main(String[] args) throws IOException {
		int v = 4;
		Graph graph = new Graph(v);
		graph.addEdge(0, 1, 5);
		graph.addEdge(1, 2, 3);
		graph.addEdge(0, 2, 10);
		graph.addEdge(1, 3, 20);
		graph.addEdge(2, 3, 2);
		graph.dijkstra(0);
	}
}
```

## output
```
Shortest distance from 0 to 0 is: 0
Shortest distance from 0 to 1 is: 5
Shortest distance from 0 to 2 is: 8
Shortest distance from 0 to 3 is: 10
```
