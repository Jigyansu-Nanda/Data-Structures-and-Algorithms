# Kosaraju's Algorithm for finding Strongly Connected Components
  - Sort the vertices in the decreasing order of their dfs finishing time.
  - Reverse the edges. (This is done to ensure that the components are actually SCCs. A SCC remains as an SCC even after all edges in it are reversed.
  - Run another dfs on the new graph. Each reachable component is a strongly connnected component.
  
## Implementation
```java
import java.io.*;
import java.util.*;

class Graph {

	int v;
	ArrayList<ArrayList<Integer>> graph;

	Graph (int v) {
		this.v = v;
		this.graph = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<v; i++) {
			graph.add(new ArrayList<Integer>());
		}
	}

	void addEdge (int src, int dst) {
		graph.get(src).add(dst);
	}

	void kosaraju () {
		boolean[] vis = new boolean[v];
		Stack<Integer> st = new Stack<Integer>();
		for (int i=0; i<v; i++) {
			if (vis[i] == false) {
				topoSort(i, st, vis);
			}
		}
		Graph g = new Graph(v);
		for (int i=0; i<v; i++) {
			for (int nbr: graph.get(i)) {
				g.addEdge(nbr, i);
			}
		}
		Arrays.fill(vis, false);
		int componentCount = 0;
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		while (!st.isEmpty()) {
			int curr = st.pop();
			if (vis[curr] == false) {
				componentCount++;
				ArrayList<Integer> subres = new ArrayList<Integer>();
				dfs(g, curr, vis, subres);
				res.add(subres);
			}
		}
		System.out.println("Total number of strongly connected components are: "+componentCount);
		for (int i=0; i<res.size(); i++) {
			for (int j=0; j<res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

	void topoSort (int src, Stack<Integer> st, boolean[] vis) {
		vis[src] = true;
		for (int nbr: graph.get(src)) {
			if (vis[nbr] == false) {
				topoSort(nbr, st, vis);
			}
		}
		st.push(src);
	}

	void dfs (Graph g, int src, boolean[] vis, ArrayList<Integer> subres) {
		vis[src] = true;
		subres.add(src);
		for (int nbr: g.graph.get(src)) {
			if (vis[nbr] == false) {
				dfs(g, nbr, vis, subres);
			}
		}
	}
}

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		// BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine().trim());
		while (t-- > 0) {
			String[] nums = in.readLine().trim().split(" ");
			int v = Integer.parseInt(nums[0]);
			int e = Integer.parseInt(nums[1]);
			Graph graph = new Graph(v);
			for (int i=0; i<e; i++) {
				nums = in.readLine().trim().split(" ");
				int src = Integer.parseInt(nums[0]);
				int dst = Integer.parseInt(nums[1]);
				graph.addEdge(src, dst);
			}
			graph.kosaraju();
			System.out.println();
		}
	}
}
```

## input
```
First line contains an integer denoting number of test cases (t).
First line of each test case contains two space separated integers (v, number of vertices and e, number of edges)
Next e lines contains two integers denoting i and j such that there is a directed edge from i to j

2
4 4
0 1
1 3
3 0
1 2
5 5
0 1
1 2
2 0
1 3
3 4
```
## output
```
Total number of strongly connected components are: 2
0 3 1 
2 

Total number of strongly connected components are: 3
0 2 1 
3 
4 
```
