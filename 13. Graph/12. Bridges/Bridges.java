import java.io.*;
import java.util.*;

class Graph {

	int v;
	ArrayList<ArrayList<Integer>> graph;
	int time = 0;

	public Graph (int v) {
		this.v = v;
		this.graph = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<v; i++) {
			graph.add(new ArrayList<Integer>());
		}
	}

	void addEdge (int src, int dst) {
		graph.get(src).add(dst);
		graph.get(dst).add(src);
	}

	void findBridges () {
		boolean[] vis = new boolean[v];
		int[] parent = new int[v];
		Arrays.fill(parent, -1);
		int[] low = new int[v];
		int[] disc = new int[v];
		for (int i=0; i<v; i++) {
			if (vis[i] == false) {
				dfs(i, vis, parent, low, disc);
			}
		}
	}

	void dfs (int src, boolean[] vis, int[] parent, int[] low, int[] disc) {
		vis[src] = true; 
		disc[src] = low[src] = ++time;
		int children = 0;
		for (int adj: graph.get(src)) {
			if (!vis[adj]) {
				children++;
				parent[adj] = src;
				dfs(adj, vis, parent, low, disc);
				low[src] = Math.min(low[src], low[adj]);
				if (low[adj] > disc[src]) {
					System.out.println(src+" "+adj);
				}
			}
			else if (parent[src] != adj) {
				low[src] = Math.min(low[src], disc[adj]);
			}
		}
	}

}

public class Bridges {

	public static void main (String[] args) throws IOException {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);
		graph.findBridges();
	}
}
