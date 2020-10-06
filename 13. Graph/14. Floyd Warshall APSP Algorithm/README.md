# Floyd Warshall Shortest Path Algorithm
  - Floyd Warshall **All-Pair-Shortest-Path (APSP) algorithm** is a dynamic programming based algorithm, that computes shortest distances between all possible pair(source, destination) of vertices. 
  - This algorithm is relatively slower than even Bellman Ford algorithm. For even slightly higher number of vertices this algorithm takes quite some time to compute all pair shortest paths.
  - The crucial advantage of this algorithm is that, after computation, it gives shortest paths among all possible pairs of source and destination vertex, iff path exists.

## Idea behind the algorithm
  - For each vertex, we update all shortest path from any source to any destination vertex, that contains this vertex as an intermediate vertex.
  - For all pairs of source to destination, we check whether through this intermediate vertex, a shorter path is possible or not.
  
## Time Complexity: O(V³)

## Pros
  - Works for both weighted & unweighted graph
  - Works for both cyclic & acyclic graph
  - Works for both directed & undirected graph
  - Works for negative weight edges
  - Detects negative weight edge cycles, if any

## Cons
  - Time Complexity very high
  
## Pseudo code
```
floydWarshall(Graph[V], source, destination) {
              1. intialize distance[V][V]
              2. for (i from 1 to V) 
                    for (j from 1 to V)
                        if (edge from i to j exists)
                          distance[i][j] = weight(i, j)
                        else if (i == j) 
                          distance[i][j] = 0
                        else 
                          distance[i][j] = INF
              3. for (k from 1 to V)
                    for (i from 1 to V) 
                        for (j from 1 to V)
                            if (distance[i][k] === INF || distance[k][j] === INF)
                              continue
                            if (distance[i][j] > distance[i][k] + distance[k][j]) 
                              distance[i][j] = distance[i][k] + distance[k][j]
              4. return distance[source][destination]
 ```
 
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
		graph.get(dst).add(new Pair(src, weight));
	}

	void floydWarshall () {
		long[][] dp = new long[v][v];
		for (int i=0; i<v; i++) {
			for (int j=0; j<v; j++) {
				if (i!=j) {
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		for (int i=0; i<v; i++) {
			for (Pair adj: graph.get(i)) {
				dp[i][adj.x] = adj.y;
			}
		}
		for (int k=0; k<v; k++) {
			for (int i=0; i<v; i++) {
				for (int j=0; j<v; j++) {
					if (dp[i][j] > dp[i][k] + dp[k][j]) {
						dp[i][j] = dp[i][k] + dp[k][j];
					}
				}
			}
		}
		for (int i=0; i<v; i++) {
			for (int j=0; j<v; j++) {
				System.out.println("Shortest distance from "+i+" to "+j+" is: "+dp[i][j]);
			}
			System.out.println();
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
		graph.floydWarshall();
	}
}
```

## output
```
Shortest distance from 0 to 0 is: 0
Shortest distance from 0 to 1 is: 5
Shortest distance from 0 to 2 is: 8
Shortest distance from 0 to 3 is: 10

Shortest distance from 1 to 0 is: 5
Shortest distance from 1 to 1 is: 0
Shortest distance from 1 to 2 is: 3
Shortest distance from 1 to 3 is: 5

Shortest distance from 2 to 0 is: 8
Shortest distance from 2 to 1 is: 3
Shortest distance from 2 to 2 is: 0
Shortest distance from 2 to 3 is: 2

Shortest distance from 3 to 0 is: 10
Shortest distance from 3 to 1 is: 5
Shortest distance from 3 to 2 is: 2
Shortest distance from 3 to 3 is: 0
```
