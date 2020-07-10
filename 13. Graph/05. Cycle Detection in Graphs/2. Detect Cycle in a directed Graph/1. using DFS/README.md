# Cycle Detection in Directed Graph using DFS

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

	static boolean DFSutil(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited, boolean[] recStack) {
		visited[src] = true;
		recStack[src] = true;
		for (int next: graph.get(src)) {
			if (visited[next]==false && DFSutil(graph, next, visited, recStack)) {
				return true;
			}
			else if (recStack[next] == true) {
				return true;
			}
		}
		recStack[src] = false;
		return false;
	}

	static boolean DFS(ArrayList<ArrayList<Integer>> graph, int v) {
		boolean[] visited = new boolean[v];
		// to identify back edges in recursion call stack
		boolean[] recStack = new boolean[v];
		for (int i=0; i<v; i++) {
			if (visited[i] == false) {
				if (DFSutil(graph, i, visited, recStack)==true) {
					return true;
				}
			}
		}
		return false;
	}	

	public static void main(String[] args) throws IOException {
		// v = number of vertices
		int v = 6;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<v; i++) {
			graph.add(new ArrayList<Integer>());
		}
		addEdge(graph, 0, 1);
		addEdge(graph, 2, 1);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);
		addEdge(graph, 4, 5);
		addEdge(graph, 5, 3);
		printGraph(graph);
		System.out.println();
		System.out.println(DFS(graph, v));
	}
}
```

## output
```
0 --> 1 
1 --> 
2 --> 1 3 
3 --> 4 
4 --> 5 
5 --> 3 

true
```
