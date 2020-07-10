# DFS of disconnected Graph

```java
import java.io.*;
import java.util.*;

class Graph {

	static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
		graph.get(v).add(u);
		
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

	static void DFSutil(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited) {
		visited[src] = true;
		System.out.print(src+" ");
		for (int k: graph.get(src)) {
			if (visited[k] == false) {
				DFSutil(graph, k, visited);
			}
		}
	}

	static void DFS(ArrayList<ArrayList<Integer>> graph, int v) {
		boolean[] visited = new boolean[v+1];
		for (int i=0; i<v; i++) {
			if (visited[i] == false) {
				DFSutil(graph, i, visited);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		// v = number of vertices
		int v = 7;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<v; i++) {
			graph.add(new ArrayList<Integer>());
		}
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 2);
		addEdge(graph, 2, 3);
		addEdge(graph, 1, 3);
		addEdge(graph, 4, 5);
		addEdge(graph, 4, 6);
		addEdge(graph, 5, 6);
		printGraph(graph);
		System.out.println();
		System.out.println("DFS of disconnected Graph:");
		DFS(graph, v);
	}
}
```

## output
```
0 --> 1 2 
1 --> 0 3 
2 --> 0 3 
3 --> 2 1 
4 --> 5 6 
5 --> 4 6 
6 --> 4 5 

DFS of disconnected Graph:
0 1 3 2 4 5 6 
```
