import java.io.*;

class SegmentTree {

	static int buildSegmentTree(int[] tree, int[] arr, int start, int end, int index) {
		if (start == end) {
			tree[index] = arr[start];
			return tree[index];
		}
		int mid = start + (end-start)/2;
		int left = buildSegmentTree(tree, arr, start, mid, (2*index)+1);
		int right = buildSegmentTree(tree, arr, mid+1, end, (2*index)+2);
		tree[index] = left+right;
		return tree[index];
	}

	static int getSum(int[] tree, int qs, int qe, int start, int end, int index) {
		if (end < qs || start > qe) {return 0;}
		if (qs <= start && end <= qe) {return tree[index];}
		int mid = start + (end-start)/2;
		int leftSum = getSum(tree, qs, qe, start, mid, (2*index)+1);
		int rightSum = getSum(tree, qs, qe, mid+1, end, (2*index)+2);
		return leftSum+rightSum;
	}

	static void update(int[] tree, int[] arr, int n, int i, int value) {
		int diff = value-arr[i];
		arr[i] = value;
		updateUtil(tree, i, diff, 0, n-1, 0);
	}

	static void updateUtil(int[] tree, int i, int diff, int start, int end, int index) {
		if(i < start || i > end) {return;}
		tree[index] += diff;
		if (end > start) {
			int mid = start + (end-start)/2;
			updateUtil(tree, i, diff, start, mid, (2*index)+1);
			updateUtil(tree, i, diff, mid+1, end, (2*index)+2);
		}
	}

	public static void main(String[] args) throws IOException{
		int[] arr = {10, 20, 30, 40};
		int n = arr.length;
		int size = 4*n;
		int[] tree = new int[size];
		buildSegmentTree(tree, arr, 0, n-1, 0);
		System.out.println(getSum(tree, 0, 3, 0, n-1, 0));
		System.out.println(getSum(tree, 1, 2, 0, n-1, 0));
		System.out.println(getSum(tree, 1, 3, 0, n-1, 0));
		update(tree, arr, n, 1, 25);
		System.out.println(getSum(tree, 0, 3, 0, n-1, 0));
		System.out.println(getSum(tree, 1, 2, 0, n-1, 0));
		System.out.println(getSum(tree, 1, 3, 0, n-1, 0));
		update(tree, arr, n, 2, 12);
		System.out.println(getSum(tree, 0, 3, 0, n-1, 0));
		System.out.println(getSum(tree, 1, 2, 0, n-1, 0));
		System.out.println(getSum(tree, 1, 3, 0, n-1, 0));
	}
}
