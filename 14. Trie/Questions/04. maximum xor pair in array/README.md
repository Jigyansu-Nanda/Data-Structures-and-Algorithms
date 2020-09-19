### Problem statement
Given an array, find maximum possible XOR of any distinct pair.

### input
```
First line conatains an integer t (number of test cases)
Each testcases contains two lines
First line of each testcase contains an integer n (size of array)
Second line of each testcase contains n elements of array
```

### sample input
```
2
6
25 10 2 8 5 3
7
1 2 3 4 5 6 7
```

### sample output
```
28
7
```

### code
```java
import java.io.*;
import java.util.*;

class Node {

	Node[] child;

	Node () {
		this.child = new Node[2];
	}
}

class Trie {

	Node root;

	Trie () {
		this.root = new Node();
	}

	void insert (int num) {
		Node curr = root;
		for (int bit=31; bit>=0; bit--) {
			int bitIndex = num & (1 << bit);
			if (bitIndex == 0) {
				if (curr.child[bitIndex] == null) {
					curr.child[bitIndex] = new Node();
				}
				curr = curr.child[bitIndex];
			} else {
				if (curr.child[1] == null) {
					curr.child[1] = new Node();
				}
				curr = curr.child[1]; 
			}
		}
	}
}


class Solution {

	static int maxXOR (int[] arr, int n) {
		Trie trie = new Trie();
		for (int x: arr) {
			trie.insert(x);
		}
		int max_xor = Integer.MIN_VALUE;
		for (int x: arr) {
			Node curr = trie.root;
			int curr_xor = 0;
			for (int bit=31; bit>=0; bit--) {
				int bitIndex = x & (1 << bit);
				if (bitIndex == 0) {
					if (curr.child[1] != null) {
						curr = curr.child[1];
						curr_xor |= (1 << bit);
					} else {
						curr = curr.child[0];
					}
				} else {
					if (curr.child[0] != null) {
						curr = curr.child[0];
						curr_xor |= (1 << bit);
					} else {
						curr = curr.child[1];
					}
				}
			}
			max_xor = Math.max(max_xor, curr_xor);
		}
		return max_xor;
	}

	public static void main(String[] args) throws IOException {
		File text = new File("input.txt");
		Scanner sc = new Scanner(text);
		// Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(maxXOR(arr, n));
		}
	}
}
```

### output
```
28
7
```
