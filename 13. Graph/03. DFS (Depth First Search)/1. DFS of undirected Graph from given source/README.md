# Print DFS of undirected Graph from given source

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

	static void DFS(ArrayList<ArrayList<Integer>> graph, int v, int src) {
		boolean[] visited = new boolean[v+1];
		DFSutil(graph, src, visited);
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		// v = number of vertices
		int v = 6;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<v; i++) {
			graph.add(new ArrayList<Integer>());
		}
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 2, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 4, 5);
		printGraph(graph);
		System.out.println();
		int src = 0;
		System.out.println("DFS of Graph from source "+src+":");
		DFS(graph, v, src);
	}
}
```

## output
```
0 --> 1 2 
1 --> 0 3 4 
2 --> 0 3 
3 --> 1 2 
4 --> 1 5 
5 --> 4 

DFS of Graph from source 0:
0 1 3 2 4 5 
```
