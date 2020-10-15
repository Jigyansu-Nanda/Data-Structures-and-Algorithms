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

    void artnPoints () {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        boolean[] ap = new boolean[n];
        int[] disc = new int[n];
        Arrays.fill(disc, -1);
        int[] low = new int[n];
        for (int i=0; i<n; i++) {
            if (disc[i] == -1) {
                dfs(i, disc, low, parent, ap);
            }
        }
        for (int i=0; i<n; i++) {
            if (ap[i]) {
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }


    void dfs (int src, int[] disc, int[] low, int[] parent, boolean[] ap) {
        disc[src] = low[src] = ++time;
        int children = 0;
        for (int child: graph.get(src)) {
            if (disc[child] == -1) {
                children++;
                parent[child] = src;
                dfs(child, disc, low, parent, ap);
                low[src] = Math.min(low[src], low[child]);
                if (children > 1 && parent[src] == -1) {
                    ap[src] = true;
                }
                if (parent[src] != -1 && low[child] >= disc[src]) {
                    ap[src] = true;
                }
            }
            else if (parent[src] != child) {
                low[src] = Math.min(low[src], disc[child]);
            }
        }
    }

}


class Main {

	
    public static void main(String[] args) throws IOException {
    	Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.artnPoints();
    }
}
