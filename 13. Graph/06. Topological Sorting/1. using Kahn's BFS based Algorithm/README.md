# Given a Directed Cyclic Graph, print it's Topological Sort

### Pseudo Code
```
1. store indegree of every vertex
2. create a Queue (say, q)
3. add all 0 indegree vertices to q
4. initialize count as 0
5. while (q is not empty)
      a. current_vertex = q.poll()
      b. print current_vertex
      c. for every adjacent vertex of current_vertex
            1. reduce it's indegree
            2. if indegree becomes 0, add it to the queue
```

### code
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

	static void KahnBFS(ArrayList<ArrayList<Integer>> graph, int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] indegree = new int[v];
		for (int i=0; i<graph.size(); i++) {
			for (int j=0; j<graph.get(i).size(); j++) {
				indegree[graph.get(i).get(j)]++;
			}
		}
		for (int i=0; i<v; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int u = q.poll();
			System.out.print(u+" ");
			for (int next: graph.get(u)) {
				indegree[next]--;
				if (indegree[next] == 0) {
					q.add(next);
				}
			}
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
		KahnBFS(graph, v);
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

0 2 3 1 4 
```
