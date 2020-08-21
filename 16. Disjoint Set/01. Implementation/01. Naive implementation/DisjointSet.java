import java.io.*;
import java.util.*;

class DisjointSet {

	static int[] parent;

	// initialize all values as their own parent
	static void initialize(int n) {
		parent = new int[n];
		for (int i=0; i<n; i++) {
			parent[i] = i;
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
		// else, set parent of one's representative
		// as other representative
		parent[rep_of_y] = rep_of_x;
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
