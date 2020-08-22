import java.io.*;
import java.util.*;

class DisjointSet {

	static int[] parent;
	static int[] rank;

	// initialize all values as their own parent
	// initialize rank of all values as 0
	static void initialize(int n) {
		parent = new int[n];
		rank = new int[n];
		for (int i=0; i<n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}

	static int find(int x) {
		// if element is it's own representative,
		// return it's value
		if (parent[x] == x) {
			return x;
		}
		// else, return representative of
		// it's parent
		return find(parent[x]);
	}

	static void union(int x, int y) {
		int rep_of_x = find(x);
		int rep_of_y = find(y);
		// if already in same subset, return
		if (rep_of_x == rep_of_y) {return ;}
		// take the larger height tree, and
		// make it parent of smaller height tree
		if (rank[rep_of_x] < rank[rep_of_y]) {
			parent[rep_of_x] = rep_of_y;
		}
		if (rank[rep_of_y] < rank[rep_of_x]) {
			parent[rep_of_y] = rep_of_x;
		}
		// if both have equal rank,
		// choose parent of one to be another,
		// increase rank of parent
		else {
			parent[rep_of_x] = rep_of_y;
			rank[rep_of_y] += 1;
		}
	}

	public static void main(String[] args) throws IOException {
		// driver code
		initialize(5);
		union(0, 3);
		union(1, 4);
		System.out.println(find(1) == find(4));
		System.out.println(find(2));
	}
}
