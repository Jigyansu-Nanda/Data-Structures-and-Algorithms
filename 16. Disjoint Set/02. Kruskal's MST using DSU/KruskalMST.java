import java.io.*;
import java.util.*; 

class KruskalMST {

	static class Edge implements Comparable<Edge> {

		int src;
		int dst;
		int weight;

		Edge (int src, int dst, int weight) {
			this.src = src;
			this.dst = dst;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge edge) {
			return (this.weight - edge.weight);
		}
	}

	static int find(int[] parent, int vertex) {
		if (parent[vertex] == vertex) {
			return vertex;
		}
		parent[vertex] = find(parent, parent[vertex]);
		return parent[vertex];
	}

	static void union(int[] parent, int[] rank, int vertex1, int vertex2) {
		int rep1 = find(parent, vertex1);
		int rep2 = find(parent, vertex2);
		if (rep1 == rep2) {return;}
		if (rank[rep1] < rank[rep2]) {
			parent[rep1] = rep2;
		}
		if (rank[rep2] < rank[rep1]) {
			parent[rep2] = rep1;
		}
		else {
			parent[rep1] = rep2;
			rank[rep2] += 1;
		}
	}

	static int kruskalMST(Edge[] edge, int v, int e) {
		Arrays.sort(edge);
		int[] parent = new int[v+1];
		for (int i=0; i<v+1; i++) {
			parent[i] = i;
		}
		int[] rank = new int[v+1];
		Arrays.fill(rank, 0);
		int minWeight = 0;
		for (int i=0; i<e; i++) {
			Edge curr = edge[i];
			int v1 = curr.src;
			int v2 = curr.dst;
			int w = curr.weight;
			if (find(parent, v1) != find(parent, v2)) {
				union(parent, rank, v1, v2);
				minWeight += w;
			}
		}
		return minWeight;
	}

	public static void main(String[] args) throws IOException {
		// driver code
		int v = 4;
		int e = 5;
		Edge[] edge = new Edge[5];
		edge[0] = new Edge(0, 1, 10);
		edge[1] = new Edge(1, 3, 15);
		edge[2] = new Edge(3, 2, 4);
		edge[3] = new Edge(2, 0, 6);
		edge[4] = new Edge(0, 3, 5);
		int mstWeight = kruskalMST(edge, v, e);
		System.out.println("The cost of MST is: "+mstWeight);
	}
}
