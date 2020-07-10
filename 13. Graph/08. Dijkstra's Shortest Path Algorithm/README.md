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
    Insert all distance to Priority Queue pq                           // O(V) time
    while pq is not empty:                                             // loop runs V times
          u = pq.extractMin( )                                         // O(log V) time, overall time O(Vlog V) time
          for (all v: adjacent of u):
                if (distance[v] > distance[u] + weight(u, v)):
                      distance[v] = distance[u] + weight(u, v)         // overall time O(Elog V)
                                  
                                                                       // overall Time Complexity: O(Vlog V + Elog V)
```

## code
```java
import java.io.*;
import java.util.*;

class Graph {

	static class Pair {
		String vertex;
		int weight;
		Pair(String vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}

	static void addEdge(HashMap<String, ArrayList<Pair>> graph, String u, String v, int weight, boolean biDirectional) {
		if (!graph.containsKey(u)) {
			graph.put(u, new ArrayList<Pair>());
		}
		graph.get(u).add(new Pair(v, weight));
		if (biDirectional == true) {
			if (!graph.containsKey(v)) {
				graph.put(v, new ArrayList<Pair>());
			}
			graph.get(v).add(new Pair(u, weight));
		}
	}

	static class Vertex {
		String node;
		int distance;
		Vertex(String node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}

	static class DistComparator implements Comparator<Vertex> {
		public int compare(Vertex v1, Vertex v2) {
			if (v1.distance < v2.distance) {return -1;}
			else if (v1.distance > v2.distance) {return 1;}
			else {return 0;}
		}
	}

	static void Dijkstra(HashMap<String, ArrayList<Pair>> graph, String src) {
		HashMap<String, Integer> dist = new HashMap<String, Integer>();
		int size = graph.size();
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(size, new DistComparator());
		for (String u: graph.keySet()) {
			if (u.equals(src)) {
				pq.add(new Vertex(u, 0));
				dist.put(u, 0);
			}else {
				pq.add(new Vertex(u, Integer.MAX_VALUE));
				dist.put(u, Integer.MAX_VALUE);
			}
		}
		while (!pq.isEmpty()) {
			Vertex u = pq.poll();
			for (Pair p: graph.get(u.node)) {
				if (dist.get(p.vertex) > dist.get(u.node)+p.weight) {
					Vertex curr = new Vertex(p.vertex, dist.get(p.vertex));
					pq.remove(curr);
					dist.put(p.vertex, dist.get(u.node)+p.weight);
					pq.add(new Vertex(p.vertex, dist.get(u.node)+p.weight));
				}
			}
		}
		for (String s: graph.keySet()) {
			System.out.println("Shortest distance from "+src+" to "+s+" is "+dist.get(s));
		}
	} 

	public static void main(String[] args) throws IOException {
		HashMap<String, ArrayList<Pair>> graph = new HashMap<String, ArrayList<Pair>>();
		addEdge(graph, "A", "B", 5, true);
		addEdge(graph, "A", "C", 10, true);
		addEdge(graph, "B", "C", 3, true);
		addEdge(graph, "B", "D", 20, true);
		addEdge(graph, "C", "D", 2, true);
		Dijkstra(graph, "A");
	}
}
```

## output
```
Shortest distance from A to A is 0
Shortest distance from A to B is 5
Shortest distance from A to C is 8
Shortest distance from A to D is 10
```
