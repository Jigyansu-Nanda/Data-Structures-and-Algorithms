### Problem statement
Given an array of integers. find the maximum XOR subarray value in given array. Expected time complexity O(n).

### sample input
```
3
4
1 2 3 4
6
8 1 2 12 7 6
2
4 6
```

### sample output
```
7
15
6
```

### Idea
The idea is to use prefix XOR of all elements and find the maximum pair XOR.

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
		int maxv = Integer.MIN_VALUE;
		for (int x: arr) {
			maxv = Math.max(maxv, x);
		}
		for (int i=1; i<n; i++) {
			arr[i] = arr[i] ^ arr[i-1];
		}
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
		return Math.max(max_xor, maxv);
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
