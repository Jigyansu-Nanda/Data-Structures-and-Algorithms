# Bellman Ford Shortest Path Algorithm
Bellman Ford shortest path algorithm is a dynamic programming based algorithm that computes from source node all reachable nodes. This algorithm was proposed by Alfonso Shimbel and was named after it's publishers Richard Bellman and Lester Ford Jr. .Even though this algorithm is relatively slower than Dijkstra's algorithm, it has one major advantage that, **it can detect negative weighted edge cycles.**

## Idea behind the algorithm
  - The key idea of the algorithm is **If there are V vertices in a graph (that does not contain negative weighted edge cycles), then any existing shortest path, between any source and destination vertex can not have length more than V-1.**
  - We first find out the shortest path containing 1 edge, then shortest path containing 2 edges, then 3 edges and so on..
  
## Pseudo code
```
function BellmanFord(Graph[V], source, destination) {
      1. intialize distance[V] = {INF, INF, INF, INF, INF,........}
      2. distance[source] = 0
      3. for (count 0 to V-1)
              for (every edge u to v)
                   if (distance[v] > distance[u] + weight(u, v))
                        distance[v] = distance[u] + weight(u, v)
```

## Negative weight edge cycle detection
For detection of negative weighted edge cycles, we run one more loop to check whether finalized distances are further reducing or not. If yes,then report negative weighted edge cycle.

```
for (every edge u to v) {
     if (distance[v] > distance[u] + weight(u, v)) {
         report (negative weighted edge cycle exists)
```

## Time Complexity : O(V * E)

## Pros
  - Works for both weighted & unweighted graph
  - Works for both cyclic & acyclic graph
  - Works for both directed & undirected graph
  - Works for negative weight edges
  - Detects negative weight edge cycles, if any
  
## Cons
  - Slower than Dijkstra's algorithm
 
## Implementation
```java
import java.io.*;
import java.util.*;

class Pair {

	int x;
	long y;

	Pair (int x, long y) {
		this.x = x;
		this.y = y;
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
		// graph.get(dst).add(new Pair(src, weight));
	}

	void bellmanFord (int src) {
		long[] distance = new long[v];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[src] = 0;
		for (;;) {
			boolean pathFound = false;
			for (int vertex=0; vertex<v; vertex++) {
				for (Pair adj: graph.get(vertex)) {
					if (distance[vertex] != Integer.MAX_VALUE) {
						if (distance[adj.x] > distance[vertex] + adj.y) {
							distance[adj.x] = distance[vertex] + adj.y;
							pathFound = true;
						}
					}
				}
			}
			if (!pathFound) {break;}
		}
		for (int i=0; i<v; i++) {
			System.out.println("Shortest distance from "+src+" to "+i+" is: "+distance[i]);
		}
	}
}

class Main {

	public static void main(String[] args) throws IOException {
		int v = 4;
		Graph graph = new Graph(v);
		graph.addEdge(0, 1, 1);
		graph.addEdge(1, 2, -3);
		graph.addEdge(0, 2, 4);
		graph.addEdge(1, 3, 2);
		graph.addEdge(2, 3, 3);
		graph.bellmanFord(0);
	}
}
```

## output
```
Shortest distance from 0 to 0 is: 0
Shortest distance from 0 to 1 is: 1
Shortest distance from 0 to 2 is: -2
Shortest distance from 0 to 3 is: 1
```
