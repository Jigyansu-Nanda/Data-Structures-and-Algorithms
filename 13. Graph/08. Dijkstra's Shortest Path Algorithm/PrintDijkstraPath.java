import java.io.*;
import java.util.*;

class PrintDijkstraPath {

	static class Pair {
		String vertex;
		int weight;
		Pair(String vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}

	static void addEdge(HashMap<String, ArrayList<Pair>> graph, String u, String v, int weight, boolean biDirectional) {
		if (!graph.containsKey(u)) {
			graph.put(u, new ArrayList<Pair>());
		}
		graph.get(u).add(new Pair(v, weight));
		if (biDirectional == true) {
			if (!graph.containsKey(v)) {
				graph.put(v, new ArrayList<Pair>());
			}
			graph.get(v).add(new Pair(u, weight));
		}
	}

	static class Vertex {
		String node;
		int distance;
		Vertex(String node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}

	static class DistComparator implements Comparator<Vertex> {
		public int compare(Vertex v1, Vertex v2) {
			if (v1.distance < v2.distance) {return -1;}
			else if (v1.distance > v2.distance) {return 1;}
			else {return 0;}
		}
	}

	static void DijkstraPath(HashMap<String, ArrayList<Pair>> graph, String src, String dst) {
		HashMap<String, Integer> dist = new HashMap<String, Integer>();
		HashMap<String, String> parent = new HashMap<String, String>();
		int size = graph.size();
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(size, new DistComparator());
		for (String u: graph.keySet()) {
			if (u.equals(src)) {
				pq.add(new Vertex(u, 0));
				dist.put(u, 0);
			}else {
				pq.add(new Vertex(u, Integer.MAX_VALUE));
				dist.put(u, Integer.MAX_VALUE);
			}
		}
		while (!pq.isEmpty()) {
			Vertex u = pq.poll();
			for (Pair p: graph.get(u.node)) {
				if (dist.get(p.vertex) > dist.get(u.node)+p.weight) {
					parent.put(p.vertex, u.node);
					Vertex curr = new Vertex(p.vertex, dist.get(p.vertex));
					pq.remove(curr);
					dist.put(p.vertex, dist.get(u.node)+p.weight);
					pq.add(new Vertex(p.vertex, dist.get(u.node)+p.weight));
				}
			}
		}
		System.out.println("Shortest destination from "+src+" to "+dst+" is "+dist.get(dst));
		String destination = dst;
		while (destination != src) {
			System.out.print(destination+" <--- ");
			destination = parent.get(destination);
		}
		System.out.print(src);
		System.out.println();
	} 

	public static void main(String[] args) throws IOException {
		HashMap<String, ArrayList<Pair>> graph = new HashMap<String, ArrayList<Pair>>();
		addEdge(graph, "A", "B", 5, true);
		addEdge(graph, "A", "C", 10, true);
		addEdge(graph, "B", "C", 3, true);
		addEdge(graph, "B", "D", 20, true);
		addEdge(graph, "C", "D", 2, true);
		DijkstraPath(graph, "A", "D");
	}
}
