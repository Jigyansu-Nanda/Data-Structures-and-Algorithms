## Given a Directed Acyclic Weighted Graph and a Source vertex, find shortest distance to all other Nodes. If a Node is not reachable, return INF.

  - Bellman-Ford Algorithm [Time Complexity: O(VE)]<br>
  - Dijkstra's Algorithm [Time Complexity: O(Elog(V))]<br>
  - Using Topological-Sorting [Time Complexity: O(V+E)]

### Pseudo code
```
  ShortestPath(graph, src)
  {
      Initialize distance[v] = {INF, INF, INF, INF, INF............}
      distance[src] = 0
      Find a Topological-Sort of the graph
      For every vertex u in the topological sort:
          For every adjacent v of u:
              if (distance[v] > distance[u] + weight(u, v)):
                  distance[v] = distance[u] + weight(u, v)
  }
```

### Code
```java
import java.io.*;
import java.util.*;

class Graph {

	static class Pair {
		int node;
		int weight;
		Pair(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}

	static void addEdge(HashMap<Integer, ArrayList<Pair>> graph, int u, int v, int weight) {
		graph.get(u).add(new Pair(v, weight));
	}

	// Finding Topological Sort
	static ArrayList<Integer> TopoLogicalSort(HashMap<Integer, ArrayList<Pair>> graph, int v) {
		int[] indegree = new int[v];
		for (int i=0; i<v; i++) {
			for (Pair p: graph.get(i)) {
				indegree[p.node]++;
			}
		}
		ArrayList<Integer> topoSort = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i=0; i<v; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int p = q.poll();
			topoSort.add(p);
			for (Pair curr: graph.get(p)) {
				indegree[curr.node]--;
				if (indegree[curr.node] == 0) {
					q.add(curr.node);
				}
			}
		}
		return topoSort;
	}

	// Shortest Path in DAG
	static void ShortestPathDAG(HashMap<Integer, ArrayList<Pair>> graph, ArrayList<Integer> topoSort, int src) {
		int[] distance = new int[graph.size()];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[src] = 0;
		for (int u: topoSort) {
			for (Pair adj: graph.get(u)) {
				if (distance[adj.node] > distance[u] + adj.weight) {
					distance[adj.node] = distance[u] + adj.weight;
				}
			}
		}
		for (int i=0; i<graph.size(); i++) {
			System.out.println("Shortest distance from "+src+" to "+distance[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		// v = number of vertices
		int v = 6;
		HashMap<Integer, ArrayList<Pair>> graph = new HashMap<Integer, ArrayList<Pair>>();
		for (int i=0; i<v; i++) {
			graph.put(i, new ArrayList<Pair>());
		}
		addEdge(graph, 0, 1, 2);
		addEdge(graph, 1, 2, 3);
		addEdge(graph, 2, 3, 6);
		addEdge(graph, 0, 4, 1);
		addEdge(graph, 4, 2, 2);
		addEdge(graph, 4, 5, 4);
		addEdge(graph, 5, 3, 1);
		int src = 0;
		ArrayList<Integer> topoSort = TopoLogicalSort(graph, v);
		ShortestPathDAG(graph, topoSort, src);
	}
}
```

## output
```
Shortest distance from 0 to 0
Shortest distance from 0 to 2
Shortest distance from 0 to 3
Shortest distance from 0 to 6
Shortest distance from 0 to 1
Shortest distance from 0 to 5
```
