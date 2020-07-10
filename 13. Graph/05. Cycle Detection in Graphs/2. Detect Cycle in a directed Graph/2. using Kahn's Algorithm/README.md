# Detect cycle in Directed Graph using Kahn's BFS based Algorithm

## idea
If there is a cycle in the directed graph, then there is not fixed starting point, from which we can follow the dependencies, because all the vertices in the cycle are dependent on each other. So we will never be able to process all the vertices inside queue. Because queue contains vertices with indegree 0.

## pseudo code
```
1. store indegree of every vertex
2. create a Queue (say, q)
3. add all 0 indegree vertices to q
4. initialize count as 0
5. while (q is not empty)
      a. current_vertex = q.poll()
      b. for every adjacent vertex of current_vertex
            1. reduce it's indegree
            2. if indegree becomes 0, add it to the queue
      c. increment count
6. return (count != number of vertices)
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

	static boolean KahnBFS(ArrayList<ArrayList<Integer>> graph, int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		int count = 0;
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
			for (int next: graph.get(u)) {
				indegree[next]--;
				if (indegree[next] == 0) {
					q.add(next);
				}
				count++;
			}
		}
		return (count != v);
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
		System.out.println(KahnBFS(graph, v));
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
