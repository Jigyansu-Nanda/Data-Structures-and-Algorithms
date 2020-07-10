# Given an unweighted graph and a source vertex, find shortest distance to all reachable vertices.

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

	static void ShortestPathBFS(ArrayList<ArrayList<Integer>> graph, int src) {
		HashMap<Integer, Integer> distance = new HashMap<Integer, Integer>();
		for (int i=0; i<graph.size(); i++) {
			if (i == src) {
				distance.put(src, 0);
			}else {
				distance.put(i, Integer.MAX_VALUE);
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);
		while (!q.isEmpty()) {
			int u = q.poll();
			for (int next: graph.get(u)) {
				if (distance.get(next) == Integer.MAX_VALUE) {
					distance.put(next, distance.get(u)+1);
					q.add(next);
				}
			}
		}
		for (int i=0; i<graph.size(); i++) {
			System.out.println("shortest distance from "+src+" to "+i+" is "+distance.get(i));
		}
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
		addEdge(graph, 3, 4);
		addEdge(graph, 4, 5);
		printGraph(graph);
		System.out.println();
		ShortestPathBFS(graph, 1);
	}
}
```

## output
```
0 --> 1 2 
1 --> 0 3 
2 --> 0 3 
3 --> 1 2 4 
4 --> 3 5 
5 --> 4 

shortest distance from 1 to 0 is 1
shortest distance from 1 to 1 is 0
shortest distance from 1 to 2 is 2
shortest distance from 1 to 3 is 1
shortest distance from 1 to 4 is 2
shortest distance from 1 to 5 is 3
```
