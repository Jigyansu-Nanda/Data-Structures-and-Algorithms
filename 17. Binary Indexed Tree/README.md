# Binary Indexed Tree / Fenwick Tree
- BIT is used for fixed-size input array and multiple queries of following types.
    - Prefix Operations (Sum, Product, XOR, OR etc..): *O(log n) for each query*
    - Update a value: *O(log n) for each query*
- It is internally represented as an array.
- It requires **O(n log n) preprocessing time** and **θ(n) auxiliary space**.
- It is also known as **Fenwick Tree**.
  
## Implementation
  - The basic idea behind BIT is that every number can be represented as sum of powers of 2.
  - for any prefix query till range i:
    - prefixOpQuery(i) performs prefix operation till index i (total i+1 elements)
    - We can divide these (i+1) elements in different ranges, that are all powers of 2.
  - A fenwick tree can support the following range operations in logarithmic time:
    - **Point Update & Range Query**
        - standard Fenwick Tree implementation
    - **Range Update & Point Query**
        - Range Update from l to r:
            - rangeUpdate(l, r, value): pointUpdate(l, currDifference) -> pointUpdate(r+1, -currDifference)
        - Point Query:
            - pointQuery(l): rangeQuery(l) - rangeQuery(l-1)
    - **Range Update & Range Query**
    
## prefix sum implementation
```java
import java.io.*;
import java.util.*;

class FenwickTree {

	int n;
	int[] arr;
	int[] tree;

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

	int getSum (int index) {
		index += 1;
		int sum = 0;
		while (index > 0) {
			sum += tree[index];
			index = index - (index & (-index));
		}
		return sum;
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
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		int[] arr = new int[] {10, 20, 30, 40, 50, 60};
		FenwickTree tree = new FenwickTree(arr);
		System.out.println(tree.getSum(4));
		System.out.println(tree.getSum(3));
		tree.update(4, 0);
		System.out.println(tree.getSum(4));
		System.out.println(tree.getSum(3));
		System.out.println(tree.getSum(5));
	}
}
```

## output
```
150
100
100
100
160
```
