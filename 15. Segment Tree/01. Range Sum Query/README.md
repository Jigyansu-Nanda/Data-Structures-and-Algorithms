## Segement Tree for range sum queries and update queries in an array

```java
import java.io.*;

class SegmentTree {

    // constructing Segment Tree
    static int buildSegmentTree(int[] tree, int[] arr, int start, int end, int index) {
    	// base case
    	if (start == end) {
    		tree[index] = arr[start];
    		return tree[index];
    	}
    	// recursive case
    	int mid = start + (end-start)/2;
    	int left = buildSegmentTree(tree, arr, start, mid, (2*index)+1);
    	int right = buildSegmentTree(tree, arr, mid+1, end, (2*index)+2);
    	tree[index] = left + right;
    	return tree[index];
    }

    // range query
    /*
    	qs = query start index
	qe = query end index
	start, end = starting and ending index of range
	represented by current node
	index = index of current node
    */
    static int getSum(int[] tree, int qs, int qe, int start, int end, int index) {
    	// current range completely outside of query range
    	if (end < qs || start > qe) {return 0;}
    	// current range completely inside of query range
    	if (qs <= start && end <= qe) {return tree[index];}
    	// else
    	int mid = start + (end-start)/2;
    	int leftSum = getSum(tree, qs, qe, start, mid, (2*index)+1);
    	int rightSum = getSum(tree, qs, qe, mid+1, end, (2*index)+2);
    	return leftSum+rightSum;
    }

    // update query
    /*
    	i = index to be updated
    	val = new value at index i
    	diff = new_value - current_value
	start, end = starting and ending index of range
	represented by current node
	index = index of current node
    */
	static void update(int[] arr, int[] tree, int i, int value) {
		int diff = value-arr[i];
		arr[i] = value;
		int start = 0;
		int end = arr.length-1;
		int index = 0;
		updateUtil(tree, i, diff, start, end, index);
	}

	// utility function for update query
	static void updateUtil(int[] tree, int i, int diff, int start, int end, int index) {
		// current index completely outside of query range
		if (i < start || i > end) {return;}
		// else
		tree[index] += diff;
		if (end > start) {
			int mid = start + (end-start)/2;
			updateUtil(tree, i, diff, start, mid, (2*index)+1);
			updateUtil(tree, i, diff, mid+1, end, (2*index)+2);
		}
	}

	public static void main(String[] args) throws IOException {
		int[] array = {10,20,30,40};
		int n = array.length;
        	int size = 4 * n;
        	int[] tree = new int[size];
        	buildSegmentTree(tree, array, 0, n-1, 0);
        	System.out.println(getSum(tree, 0, 2, 0, n-1, 0));
        	System.out.println(getSum(tree, 2, 3, 0, n-1, 0));
        	System.out.println(getSum(tree, 1, 3, 0, n-1, 0));
        	update(array, tree, 1, 25);
        	System.out.println(getSum(tree, 0, 2, 0, n-1, 0));
        	System.out.println(getSum(tree, 2, 3, 0, n-1, 0));
        	System.out.println(getSum(tree, 1, 3, 0, n-1, 0));
	}
}
```

## output
```
60
70
90
65
70
95
```
