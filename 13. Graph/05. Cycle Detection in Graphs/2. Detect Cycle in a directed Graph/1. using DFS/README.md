# Cycle Detection in Directed Graph using DFS

```java
import java.io.*;
import java.util.*;

class Graph {

	ArrayList<ArrayList<Integer>> graph;
	int v;
	int e;

	public Graph (int v, int e, int[][] edges) {
		this.v = v;
		this.e = e;
		this.graph = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<v; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i=0; i<e; i++) {
			int src = edges[i][0];
			int dst = edges[i][1];
			addEdge(src, dst);
		}
	}

	void addEdge (int src, int dst) {
		graph.get(src).add(dst);
	}

	boolean isCycle () {
		boolean[] visited = new boolean[v];
		boolean[] recStack = new boolean[v];
		for (int i=0; i<v; i++) {
			if (visited[i] == false) {
				if (dfs(i, visited, recStack) == true) {
					return true;
				}
			}
		}
		return false;
	}

	boolean dfs (int src, boolean[] visited, boolean[] recStack) {
		visited[src] = true;
		recStack[src] = true;
		for (int adj : graph.get(src)) {
			if (!visited[adj] && dfs(adj, visited, recStack)) {
				return true;
			}
			else if (recStack[adj]) {
				return true;
			}
		}
		recStack[src] = false;
		return false;
	}
}

class Solution {
	
	public static void main (String[] args) throws IOException {
		int v = 6;
		int e = 7;
		int[][] edges = new int[e][2];
		edges[0][0] = 0;
		edges[0][1] = 1;
		edges[1][0] = 1;
		edges[1][1] = 2;
		edges[2][0] = 2;
		edges[2][1] = 3;
		edges[3][0] = 3;
		edges[3][1] = 4;
		edges[4][0] = 4;
		edges[4][1] = 5;
		edges[5][0] = 5;
		edges[5][1] = 3;
		edges[6][0] = 5;
		edges[6][1] = 2;
		Graph graph = new Graph(v, e, edges);
		String res = graph.isCycle() ? "Cycle exists" : "Cycle does not exist";
		System.out.println(res);

		// int v = 4;
		// int e = 4;
		// int[][] edges = new int[e][2];
		// edges[0][0] = 0;
		// edges[0][1] = 1;
		// edges[1][0] = 1;
		// edges[1][1] = 2;
		// edges[2][0] = 3;
		// edges[2][1] = 1;
		// edges[3][0] = 2;
		// edges[3][1] = 3;
		// Graph graph = new Graph(v, e, edges);
		// String res = graph.isCycle() ? "Cycle exists" : "Cycle does not exist";
		// System.out.println(res);

		// int v = 4;
		// int e = 4;
		// int[][] edges = new int[e][2];
		// edges[0][0] = 0;
		// edges[0][1] = 1;
		// edges[1][0] = 2;
		// edges[1][1] = 1;
		// edges[2][0] = 1;
		// edges[2][1] = 3;
		// edges[3][0] = 2;
		// edges[3][1] = 3;
		// Graph graph = new Graph(v, e, edges);
		// String res = graph.isCycle() ? "Cycle exists" : "Cycle does not exist";
		// System.out.println(res);
	}

}
```

## output
```
Cycle exists
```
