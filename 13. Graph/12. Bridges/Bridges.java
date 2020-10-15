import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Graph {

    int n;
    ArrayList<ArrayList<Integer>> graph;
    static int time = 0;

    Graph (int n) {
        this.n = n;
        this.graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<Integer>());
        }
    }

    void addEdge (int a, int b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    void bridges () {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int[] disc = new int[n];
        Arrays.fill(disc, -1);
        int[] low = new int[n];
        for (int i=0; i<n; i++) {
            if (disc[i] == -1) {
                dfs(i, disc, low, parent);
            }
        }
    }


    void dfs (int src, int[] disc, int[] low, int[] parent) {
        disc[src] = low[src] = ++time;
        for (int child: graph.get(src)) {
            if (disc[child] == -1) {
                parent[child] = src;
                dfs(child, disc, low, parent);
                low[src] = Math.min(low[src], low[child]);
                if (low[child] > disc[src]) {
                    System.out.println(src+" "+child);
                }
            }
            else if (parent[src] != child) {
                low[src] = Math.min(low[src], disc[child]);
            }
        }
    }

}


class Bridges {
	
    public static void main(String[] args) throws IOException {
    	Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.bridges();
    }
}
