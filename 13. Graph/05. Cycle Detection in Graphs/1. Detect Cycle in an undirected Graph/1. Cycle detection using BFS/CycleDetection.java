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
		graph.get(dst).add(src);
	}

	boolean isCycle () {
		boolean[] visited = new boolean[v];
		int[] parent = new int[v];
		Arrays.fill(parent, -1);
		for (int i=0; i<v; i++) {
			if (visited[i] == false) {
				if (bfs(i, visited, parent)) {
					return true;
				}
			}
		}
		return false;
	}

	boolean bfs (int src, boolean[] visited, int[] parent) {
		visited[src] = true;
		parent[src] = src;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int adj : graph.get(curr)) {
				if (!visited[adj]) {
					visited[adj] = true;
					parent[adj] = curr;
					q.add(adj);
				}
				else if (parent[curr] != adj) {
					return true;
				}
			}
		}
		return false;
	}
}

class CycleDetection {
	
	public static void main (String[] args) throws IOException {
		int v = 6;
		int e = 6;
		int[][] edges = new int[e][2];
		edges[0][0] = 0;
		edges[0][1] = 1;
		edges[1][0] = 1;
		edges[1][1] = 2;
		edges[2][0] = 1;
		edges[2][1] = 3;
		edges[3][0] = 2;
		edges[3][1] = 3;
		edges[4][0] = 2;
		edges[4][1] = 4;
		edges[5][0] = 4;
		edges[5][1] = 5;
		Graph graph = new Graph(v, e, edges);
		String res = graph.isCycle() ? "Cycle exists" : "Cycle does not exist";
		System.out.println(res);

		// int v = 4;
		// int e = 4;
		// int[][] edges = new int[e][2];
		// edges[0][0] = 0;
		// edges[0][1] = 1;
		// edges[1][0] = 1;
		// edges[1][1] = 2;
		// edges[2][0] = 1;
		// edges[2][1] = 3;
		// edges[3][0] = 2;
		// edges[3][1] = 3;
		// Graph graph = new Graph(v, e, edges);
		// String res = graph.isCycle() ? "Cycle exists" : "Cycle does not exist";
		// System.out.println(res);

		// int v = 4;
		// int e = 3;
		// int[][] edges = new int[e][2];
		// edges[0][0] = 0;
		// edges[0][1] = 1;
		// edges[1][0] = 1;
		// edges[1][1] = 3;
		// edges[2][0] = 1;
		// edges[2][1] = 2;
		// Graph graph = new Graph(v, e, edges);
		// String res = graph.isCycle() ? "Cycle exists" : "Cycle does not exist";
		// System.out.println(res);
	}

}
