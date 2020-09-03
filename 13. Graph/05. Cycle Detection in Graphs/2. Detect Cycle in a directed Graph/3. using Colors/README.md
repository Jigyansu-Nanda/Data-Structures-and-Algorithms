## Given a directed graph, check whether a cycle exists or not in it.
We will perform simple DFS on graph starting from any node. During DFS, we will maintain a color array to represent different state of node. 
  - **color 0**: unvisited
  - **color 1**: visited but descendants are still being processed
  - **color 2**: visited and all of it's descendants are processed
If at any time any adjacent node of current node, that is being processed, has color 1, we will know that there is a cycle

### Advantages of using colors
 - This method takes less space than other methods (Kahn's BFS based, Recursion Stack based).
 - This method can be used to find number of cycles in the graph.
 - This method can be used print any or all the cycles in an undirected graph.
 
### Code
```java
import java.io.*;
import java.util.*;

class Graph {

	ArrayList<ArrayList<Integer>> graph;
	int v;
	int e;

	public Graph (int v, int e, int[][] edges) {
		this.v = v;
		this.e = e;
		this.graph = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<v; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i=0; i<e; i++) {
			int src = edges[i][0];
			int dst = edges[i][1];
			addEdge(src, dst);
		}
	}

	void addEdge (int src, int dst) {
		graph.get(src).add(dst);
	}

	boolean isCycle () {
		int[] colors = new int[v];
		for (int i=0; i<v; i++) {
			if (colors[i] == 0) {
				if (dfs(i, colors)) {
					return true;
				}
			}
		}
		return false;
	}

	boolean dfs (int src, int[] colors) {
		colors[src] = 1;
		for (int adj : graph.get(src)) {
			if (colors[adj] == 1) {
				return true;
			}
			else if (colors[adj] == 0 && dfs(adj, colors)) {
				return true;
			}
		}
		colors[src] = 2;
		return false;
	}
}

class CycleDetection {
	
	public static void main (String[] args) throws IOException {
		int v = 6;
		int e = 7;
		int[][] edges = new int[e][2];
		edges[0][0] = 0;
		edges[0][1] = 1;
		edges[1][0] = 1;
		edges[1][1] = 2;
		edges[2][0] = 2;
		edges[2][1] = 3;
		edges[3][0] = 3;
		edges[3][1] = 4;
		edges[4][0] = 4;
		edges[4][1] = 5;
		edges[5][0] = 5;
		edges[5][1] = 3;
		edges[6][0] = 5;
		edges[6][1] = 2;
		Graph graph = new Graph(v, e, edges);
		String res = graph.isCycle() ? "Cycle exists" : "Cycle does not exist";
		System.out.println(res);

	}

}
```

#### output
```
Cycle exists
```
