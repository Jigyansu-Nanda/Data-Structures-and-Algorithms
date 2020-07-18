import java.io.*;
import java.util.*;

class SegmentTree {

	static int[] lazy;

	static int buildSegmentTree(int[] tree, int[] arr, int start, int end, int index) {
		if (start == end) {
			tree[index] = arr[start];
			return tree[index];
		}
		int mid = start + (end-start)/2;
		int left = buildSegmentTree(tree, arr, start, mid, (2*index)+1);
		int right = buildSegmentTree(tree, arr, mid+1, end, (2*index)+2);
		tree[index] = left + right;
		return tree[index];
	}

	static int getSum(int[] tree, int qs, int qe, int start, int end, int index) {
		if (start > qe || end < qs) {return 0;}
		if (qs <= start && end <= qe) {return tree[index];}
		int mid = start + (end-start)/2;
		int leftSum = getSum(tree, qs, qe, start, mid, (2*index)+1);
		int rightSum = getSum(tree, qs, qe, mid+1, end, (2*index)+2);
		return leftSum + rightSum;
	}

	static void update(int[] arr, int i, int value, int[] tree) {
		int diff = value - arr[i];
		arr[i] = value;
		int start = 0;
		int end = arr.length-1;
		int index = 0;
		updateUtil(tree, i, diff, start, end, index);
	}

	static void updateUtil(int[] tree, int i, int diff, int start, int end, int index) {
		if (i < start || i > end) {return ;}
		tree[index] += diff;
		if (end > start) {
			int mid = start + (end-start)/2;
			updateUtil(tree, i, diff, start, mid, (2*index)+1);
			updateUtil(tree, i, diff, mid+1, end, (2*index)+2);
		}
	}

	// lazy update
	static void updateRangeLazy(int[] tree, int qs, int qe, int diff, int start, int end, int index) {
		// update remaining lazy updates first
		if (lazy[index] != 0) {
			tree[index] += (end-start+1)*lazy[index];
			if (start != end) {
				lazy[(2*index)+1] += lazy[index];
				lazy[(2*index)+2] += lazy[index];
			}
			lazy[index] = 0;
		}
		// current range lies completely outside query range
		if (qe < start || end < qs || start > end) {return ;}
		// current range lies completely within query range
		if (qs <= start && end <= qe) {
			tree[index] += (end-start+1)*diff;
			if (start != end) {
				lazy[(2*index)+1] += diff;
				lazy[(2*index)+2] += diff;
			}
			return;
		}
		// partial overlap
		int mid = (start + end) >> 1;
		updateRangeLazy(tree, qs, qe, diff, start, mid, (2*index)+1);
		updateRangeLazy(tree, qs, qe, diff, mid+1, end, (2*index)+2);
		tree[index] = tree[(2*index)+1] + tree[(2*index)+2];
	}

	static int querySumLazy(int[] tree, int qs, int qe, int start, int end, int index) {
		// update remaining lazy updates first
		if (lazy[index] != 0) {
			tree[index] += (end-start+1)*lazy[index];
			if (start != end) {
				lazy[(2*index)+1] += lazy[index];
				lazy[(2*index)+2] += lazy[index];
			}
			lazy[index] = 0;
		}
		// current range lies completely outside query range
		if (qe < start || end < qs || start > end) {return 0;}
		// current range lies completely within query range
		if (qs <= start && end <= qe) {
			return tree[index];
		}
		// partial overlap
		int mid = (start + end) >> 1;
		int left = querySumLazy(tree, qs, qe, start, mid, (2*index)+1);
		int right = querySumLazy(tree, qs, qe, mid+1, end, (2*index)+2);
		return left+right;
	}

	public static void main(String[] args) throws IOException {
		int[] arr = {10, 20, 30, 40, 50};
		int n = arr.length;
		int size = 4*n;
		int[] tree = new int[size];
		lazy = new int[size];
		Arrays.fill(lazy, 0);
		buildSegmentTree(tree, arr, 0, n-1, 0);
		System.out.println(getSum(tree, 0, 2, 0, n-1, 0));
		System.out.println(getSum(tree, 3, 4, 0, n-1, 0));
		System.out.println(getSum(tree, 2, 2, 0, n-1, 0));
		System.out.println(getSum(tree, 1, 4, 0, n-1, 0));
		System.out.println();
		updateRangeLazy(tree, 0, 2, 10, 0, n-1, 0);
		System.out.println(querySumLazy(tree, 0, 2, 0, n-1, 0));
		System.out.println(querySumLazy(tree, 3, 4, 0, n-1, 0));
		System.out.println(querySumLazy(tree, 2, 2, 0, n-1, 0));
		System.out.println(querySumLazy(tree, 1, 4, 0, n-1, 0));
		System.out.println();
		updateRangeLazy(tree, 1, 4, 10, 0, n-1, 0);
		System.out.println(querySumLazy(tree, 0, 2, 0, n-1, 0));
		System.out.println(querySumLazy(tree, 3, 4, 0, n-1, 0));
		System.out.println(querySumLazy(tree, 2, 2, 0, n-1, 0));
		System.out.println(querySumLazy(tree, 1, 4, 0, n-1, 0));
	}
}
