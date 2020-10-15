import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Graph {

    int n;
    ArrayList<ArrayList<Integer>> graph;
    static int time = 0;
    HashSet<Integer> points;

    Graph (int n) {
        this.n = n;
        this.graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        this.points = new HashSet<Integer>();
    }

    void addEdge (int a, int b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    void artnPoints () {
        int[] disc = new int[n];
        Arrays.fill(disc, -1);
        int[] low = new int[n];
        for (int i=0; i<n; i++) {
            if (disc[i] == -1) {
                dfs(i, -1, disc, low);
            }
        }
        for (int x: points) {
            System.out.println(x);
        }
    }

    void dfs (int src, int parent, int[] disc, int[] low) {
        disc[src] = low[src] = ++time;
        int children = 0;
        for (int adj: graph.get(src)) {
            if (adj == parent) {continue;}
            if (disc[adj] != -1) {
                low[src] = Math.min(low[src], disc[adj]);
            }
            else {
                children++;
                dfs(adj, src, disc, low);
                low[src] = Math.min(low[src], low[adj]);
                if (children > 1 && parent == -1) {
                    points.add(src);
                }
                if (parent != -1 && low[adj] >= disc[src]) {
                    points.add(src);
                }
            }
        }
    }

}


public class Main {

	
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
