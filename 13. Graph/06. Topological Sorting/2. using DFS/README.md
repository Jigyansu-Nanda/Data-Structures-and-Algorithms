# Topological Sorting using DFS

## Pseudo code
```
// DFS
1. mark source as visited
2. for every adjacent v of source
      if v is not visited
          call DFS for v
3. push source into the stack

// Wrapper function
1. create an empty stack
2. for every vertex
      if it's not visited
          call DFS on that vertex
3. while stack is not empty
      pop items and print them
```

## code
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

	void topologicalSort () {
		boolean[] visited = new boolean[v];
		Stack<Integer> st = new Stack<Integer>();
		for (int i=0; i<v; i++) {
			if (visited[i] == false) {
				dfs(i, visited, st);
			}
		}
		while (st.isEmpty() == false) {
			System.out.print(st.pop()+" ");
		}
		System.out.println();
	}

	void dfs (int src, boolean[] visited, Stack<Integer> st) {
		visited[src] = true;
		for (int adj : graph.get(src)) {
			if (visited[adj] == false) {
				dfs(adj, visited, st);
			}
		}
		st.push(src);
	}
}

class TopologicalSort {
	
	public static void main (String[] args) throws IOException {
		int v = 5;
		int e = 5;
		int[][] edges = new int[5][2];
		edges[0][0] = 0;
		edges[0][1] = 1;
		edges[1][0] = 1;
		edges[1][1] = 3;
		edges[2][0] = 2;
		edges[2][1] = 3;
		edges[3][0] = 2;
		edges[3][1] = 4;
		edges[4][0] = 3;
		edges[4][1] = 4;
		Graph graph = new Graph(v, e, edges);
		graph.topologicalSort();
	}

}
```

## output
```
2 0 1 3 4
```
