import java.io.*;
import java.util.*;

class FenwickTree {

	int[] tree;
	int[] arr;
	int n;

	FenwickTree (int[] arr) {
		this.arr = arr;
		this.n = arr.length;
		this.tree = new int[n+1];
		buildTree();
	}

	void buildTree () {
		for (int i=0; i<n; i++) {
			updateTree(i, arr[i]);
		}
	}

	void update (int index, int value) {
		int diff = value - arr[index];
		arr[index] = value;
		updateTree(index, diff);
	}

	void updateTree (int index, int diff) {
		index += 1;
		while (index <= n) {
			tree[index] += diff;
			index = index + (index & (-index));
		}
	}

	int getSum (int index) {
		index += 1;
		int sum = 0;
		while (index > 0) {
			sum += tree[index];
			index = index - (index & (-index));
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		int[] array = {10, 20, 30, 40, 50, 60};
		FenwickTree tree = new FenwickTree(array);
		System.out.println(tree.getSum(2));
		System.out.println(tree.getSum(4));
		tree.update(3, 45);
		System.out.println(tree.getSum(4));
		System.out.println(tree.getSum(5));
	}
}
