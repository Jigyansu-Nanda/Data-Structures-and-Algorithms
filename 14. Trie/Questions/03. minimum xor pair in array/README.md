### Problem statement
Given an array, find minimum possible XOR of any distinct pair.

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
3
9 5 3
5
1 2 3 4 5
```

### sample output
```
6
1
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

	static int minXOR (int[] arr, int n) {
		Trie trie = new Trie();
		trie.insert(arr[0]);
		int min_xor = Integer.MAX_VALUE;
		for (int i=1; i<n; i++) {
			Node curr = trie.root;
			int num = arr[i];
			int curr_xor = 0;
			for (int bit=31; bit>=0; bit--) {
				int bitIndex = num & (1 << bit);
				if (bitIndex == 0) {
					if (curr.child[0] != null) {
						curr = curr.child[0];
					} else {
						curr = curr.child[1];
						curr_xor |= (1 << bit);
					}
				} else {
					if (curr.child[1] != null) {
						curr = curr.child[1];
					} else {
						curr = curr.child[0];
						curr_xor |= (1 << bit);
					}
				}
			}
			min_xor = Math.min(min_xor, curr_xor);
			trie.insert(num);
		}
		return min_xor;
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
			System.out.println(minXOR(arr, n));
		}
	}
}
```

### output
```
6
1
```
