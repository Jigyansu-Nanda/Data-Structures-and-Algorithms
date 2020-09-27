# Segement Tree for range sum queries and point-update queries in an array

## implementation
```java
import java.io.*;
import java.util.*;

class SegmentTree {

	int[] tree;
	int n;

	SegmentTree (int[] arr, int n) {
		this.n = n;
		int x = (int) (Math.log(n) / Math.log(2)) + 1;
		int size = ((1 << x) << 1) + 1;
		this.tree = new int[size];
		build(arr, 0, n-1, 0);
	}

	void build (int[] arr, int s, int e, int i) {
		if (s == e) {
			tree[i] = arr[s];
			return;
		}
		int mid = s + (e - s)/2;
		build(arr, s, mid, (2*i)+1);
		build(arr, mid+1, e, (2*i)+2);
		tree[i] = tree[(2*i)+1] + tree[(2*i)+2];
		return;
	}

	int getSum (int l, int r) {
		return getSumRec(l, r, 0, n-1, 0);
	}

	int getSumRec (int l, int r, int s, int e, int i) {
		if (r < s || l > e) {return 0;}
		if (l <= s && e <= r) {return tree[i];}
		int mid = s + (e-s)/2;
		int leftSum = getSumRec(l, r, s, mid, (2*i)+1);
		int rightSum = getSumRec(l, r, mid+1, e, (2*i)+2);
		return leftSum + rightSum;
	}

	void update (int[] arr, int index, int value) {
		int diff = value - arr[index];
		updateRec(index, diff, 0, n-1, 0);
	}

	void updateRec (int index, int diff, int s, int e, int i) {
		if (index < s || index > e) {return ;}
		tree[i] += diff;
		if (e > s) {
			int mid = s + (e-s)/2;
			updateRec(index, diff, s, mid, (2*i)+1);
			updateRec(index, diff, mid+1, e, (2*i)+2);
		}
	}
}

class Solution {

	public static void main(String[] args) throws IOException {
		int[] arr = {1,2,3,4,5};
		int n = arr.length;
		SegmentTree tree = new SegmentTree(arr, n);
		System.out.println(tree.getSum(1,4));
		tree.update(arr, 2, 90);
		System.out.println(tree.getSum(0,2));
	}
}
```

## output
```
14
93
```
