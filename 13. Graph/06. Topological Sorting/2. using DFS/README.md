# Topological Sorting using DFS

## pseudo code
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

	static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
	}

	static void printGraph(ArrayList<ArrayList<Integer>> graph) {
		for (int i=0; i<graph.size(); i++) {
			System.out.print(i+" --> ");
			for (int j=0; j<graph.get(i).size(); j++) {
				System.out.print(graph.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

	static void DFS(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited, Stack<Integer> st) {
		visited[src] = true;
		for (int next: graph.get(src)) {
			if (visited[next] == false) {
				DFS(graph, next, visited, st);
			}
		}
		st.push(src);
	}

	static void TopoSortDFS(ArrayList<ArrayList<Integer>> graph, int v) {
		Stack<Integer> st = new Stack<Integer>();
		boolean[] visited = new boolean[v];
		for (int i=0; i<v; i++) {
			if (visited[i] == false) {
				DFS(graph, i, visited, st);
			}
		}
		while (!st.isEmpty()) {
			System.out.print(st.pop()+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		// v = number of vertices
		int v = 5;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<v; i++) {
			graph.add(new ArrayList<Integer>());
		}
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 3);
		addEdge(graph, 2, 1);
		addEdge(graph, 2, 4);
		printGraph(graph);
		System.out.println();
		TopoSortDFS(graph, v);
	}
}
```

## output
```
0 --> 1 3 
1 --> 
2 --> 1 4 
3 --> 
4 --> 

2 4 0 3 1 
```
