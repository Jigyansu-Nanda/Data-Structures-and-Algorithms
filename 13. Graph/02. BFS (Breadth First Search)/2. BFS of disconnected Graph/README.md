# Print BFS of disconnected Graph

```java
import java.io.*;
import java.util.*;

class Graph {

	static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v, boolean biDirectional) {
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

	static void BFSutil(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int src) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);
		visited[src] = true;
		while(q.isEmpty()==false) {
			int u = q.poll();
			System.out.print(u+" ");
			for (int k: graph.get(u)) {
				if (visited[k] == false) {
					visited[k] = true;
					q.add(k);
				}
			}
		}
	}

	static void BFS(ArrayList<ArrayList<Integer>> graph, int v) {
		boolean[] visited = new boolean[v+1];
		for (int i=0; i<v; i++) {
			if (visited[i] == false) {
				BFSutil(graph, visited, i);
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
		addEdge(graph, 0, 1, true);
		addEdge(graph, 0, 2, true);
		addEdge(graph, 2, 3, true);
		addEdge(graph, 1, 3, true);
		addEdge(graph, 4, 5, true);
		addEdge(graph, 4, 6, true);
		addEdge(graph, 5, 6, true);
		printGraph(graph);
		System.out.println();
		System.out.println("BFS for disconnected Graph:");
		BFS(graph, v);
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

BFS for disconnected Graph:
0 1 2 3 4 5 6 
```
