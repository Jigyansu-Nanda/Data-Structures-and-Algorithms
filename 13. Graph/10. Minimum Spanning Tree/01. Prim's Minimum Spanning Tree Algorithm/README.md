# Prim's Minimum Spanning Tree Algorithm
  - Prim's MST algorithm is a greedy algorithm
  - In this algorithm, we maintain two sets of vertices
    1. vertices, that are already included in MST (initially empty)
    2. vertices, that are not yet included in MST (initially contains all the vertices)
  - At every step, we consider all the edges, that connect two sets, and pick the minimum weighted edge, then add the vertice at the other end of this edge to MST (set-1)

#### Input
```
                              0
                          8 /   \ 9
                            1    2
                        10 / \3  / 5
                          3 - 4
                            6
```

#### Output
```
                              0
                          8 /
                            1
                              \ 3
                               4
                           6 /   \ 5
                            3     2
```

#### Implementation Pseudo Code
```java
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

class MinimumSpanningTree {

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
```

#### output
```
16
```
