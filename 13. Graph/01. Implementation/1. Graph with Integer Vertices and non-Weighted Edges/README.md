# Graph Implementation (Adjacency List Representation with Integer Vertices and non-Weighted Edges)

```java
import java.io.*;
import java.util.*;

class Graph {

	static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v, boolean biDirectional) {
		graph.get(u).add(v);
		if (biDirectional == true) {
			graph.get(v).add(u);
		}
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

	public static void main(String[] args) throws IOException {
		// v = number of vertices
		int v = 5;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<v; i++) {
			graph.add(new ArrayList<Integer>());
		}
		addEdge(graph, 0, 1, true);
		addEdge(graph, 0, 2, true);
		addEdge(graph, 1, 2, true);
		addEdge(graph, 1, 3, true);
		addEdge(graph, 4, 2, true);
		printGraph(graph);
	}
}
```

## output
```
0 --> 1 2 
1 --> 0 2 3 
2 --> 0 1 4 
3 --> 1 
4 --> 2 
```
