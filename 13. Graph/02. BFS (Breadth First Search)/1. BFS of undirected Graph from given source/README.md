# Print BFS of undirected Graph from given source

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

	static void BFS(ArrayList<ArrayList<Integer>> graph, int src) {
		Queue<Integer> q = new LinkedList<Integer>();
		int v = graph.size();
		boolean[] visited = new boolean[v+1];
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
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		// v = number of vertices
		int v = 6;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<v; i++) {
			graph.add(new ArrayList<Integer>());
		}
		addEdge(graph, 0, 1, true);
		addEdge(graph, 0, 2, true);
		addEdge(graph, 2, 4, true);
		addEdge(graph, 1, 3, true);
		addEdge(graph, 3, 5, true);
		addEdge(graph, 4, 5, true);
		addEdge(graph, 0, 5, true);
		printGraph(graph);
		System.out.println();
		int src = 0;
		System.out.println("BFS from source "+src+":");
		BFS(graph, src);
	}
}
```

## output
```
0 --> 1 2 5 
1 --> 0 3 
2 --> 0 4 
3 --> 1 5 
4 --> 2 5 
5 --> 3 4 0 

BFS from source 0:
0 1 2 5 3 4 
```
