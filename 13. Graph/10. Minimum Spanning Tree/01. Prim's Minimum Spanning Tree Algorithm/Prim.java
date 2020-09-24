import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {

	int x;
	int y;

	Pair (int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo (Pair pair) {
		return (this.y - pair.y);
	}
}

class Graph {

	ArrayList<ArrayList<Pair>> graph;
	int v;

	Graph (int v) {
		this.v = v;
		this.graph = new ArrayList<ArrayList<Pair>>();
		for (int i=0; i<v; i++) {
			graph.add(new ArrayList<Pair>());
		}
	}

	void addEdge (int src, int dst, int weight) {
		graph.get(src).add(new Pair(dst, weight));
		graph.get(dst).add(new Pair(src, weight));
	}

	void primMST () {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		boolean[] mstSet = new boolean[v];
		int mstWeight = 0;
		pq.add(new Pair(0, 0));
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			int nxt = p.x;
			int weight = p.y;
			if (mstSet[nxt]) {
				continue;
			}
			mstWeight += weight;
			mstSet[nxt] = true;
			for (Pair adj: graph.get(nxt)) {
				if (mstSet[adj.x] == false) {
					pq.add(new Pair(adj.x, adj.y));
				}
			}
		}
		System.out.println(mstWeight);
	}
}

class Prim {

	public static void main(String[] args) throws IOException {
		Graph g = new Graph(5);
		g.addEdge(0, 1, 2);
		g.addEdge(1, 2, 3);
		g.addEdge(2, 4, 7);
		g.addEdge(4, 1, 5);
		g.addEdge(4, 3, 9);
		g.addEdge(3, 1, 8);
		g.addEdge(3, 0, 6);
		g.primMST();
	}
}
