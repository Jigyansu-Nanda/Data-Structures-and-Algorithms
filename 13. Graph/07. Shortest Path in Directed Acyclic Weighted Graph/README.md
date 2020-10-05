## Given a Directed Acyclic Weighted Graph and a Source vertex, find shortest distance to all other Nodes. If a Node is not reachable, return INF.

  - Bellman-Ford Algorithm [Time Complexity: O(VE)]<br>
  - Dijkstra's Algorithm [Time Complexity: O(Elog(V))]<br>
  - Using Topological-Sorting [Time Complexity: O(V+E)]

### Pseudo code
```
  ShortestPath(graph, src) {
      Initialize distance[v] = {INF, INF, INF, INF, INF............}
      distance[src] = 0
      Find a Topological-Sort of the graph
      For every vertex u in the topological sort:
          For every adjacent v of u:
              if (distance[v] > distance[u] + weight(u, v)):
                  distance[v] = distance[u] + weight(u, v)
  }
```

### Code
```java
import java.io.*;
import java.util.*;

class Pair {

	int x;
	int y;

	Pair (int x, int y) {
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

	void addEdge (int src, int dst, int weight) {
		graph.get(src).add(new Pair(dst, weight));
	}

	void shortestPath (int src) {
		long[] distance = new long[v];
		Arrays.fill(distance, (long) Integer.MAX_VALUE);
		distance[src] = 0;
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[v];
		for (int i=0; i<v; i++) {
			if (visited[i] == false) {
				dfs(i, stack, visited);
			}
		}
		while (!stack.isEmpty()) {
			int curr = stack.pop();
			for (Pair adj: graph.get(curr)) {
				if (distance[adj.x] > distance[curr] + (long) adj.y) {
					distance[adj.x] = distance[curr] + (long) adj.y;
				}
			}
		}
		for (int i=0; i<v; i++) {
			System.out.println("Shortest Distance from "+src+" to "+i+" is "+distance[i]);
		}
	}

	void dfs (int src, Stack<Integer> stack, boolean[] visited) {
		visited[src] = true;
		for (Pair adj: graph.get(src)) {
			if (visited[adj.x] == false) {
				dfs(adj.x, stack, visited);
			}
		}
		stack.push(src);
	}
}

class Main {

	public static void main(String[] args) throws IOException {
		int v = 6;
		Graph graph = new Graph(v);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 3);
		graph.addEdge(2, 3, 6);
		graph.addEdge(0, 4, 1);
		graph.addEdge(4, 2, 2);
		graph.addEdge(4, 5, 4);
		graph.addEdge(5, 3, 1);
		graph.shortestPath(0);
	}
}
```

## output
```
Shortest Distance from 0 to 0 is 0
Shortest Distance from 0 to 1 is 2
Shortest Distance from 0 to 2 is 3
Shortest Distance from 0 to 3 is 6
Shortest Distance from 0 to 4 is 1
Shortest Distance from 0 to 5 is 5
```
