# Given an Undirected Graph, detect whether the Graph contains cycle or not

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

	static boolean DFSutil(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited, int parent) {
		visited[src] = true;
		for (int next: graph.get(src)) {
			if (visited[next] == false) {
				if (DFSutil(graph, next, visited, src) == true) {
					return true;
				}
			}else if (next != parent) {
				return true;
			}
		}
		return false;
	}

	static boolean DFS(ArrayList<ArrayList<Integer>> graph, int v) {
		boolean[] visited = new boolean[v+1];
		for (int i=0; i<=v; i++) {
			if (visited[i] == false) {
				if (DFSutil(graph, i, visited, -1)==true) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		// v = number of vertices
		int v = 4;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<v; i++) {
			graph.add(new ArrayList<Integer>());
		}
		addEdge(graph, 0, 1);
		addEdge(graph, 1, 2);
		addEdge(graph, 2, 3);
		addEdge(graph, 1, 3);
		printGraph(graph);
		System.out.println(DFS(graph, v));
	}
}
```

## output
```
0 --> 1 
1 --> 0 2 3 
2 --> 1 3 
3 --> 2 1 
true
```
