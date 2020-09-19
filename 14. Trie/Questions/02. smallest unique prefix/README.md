### Problem Statement
Given a collection of words, for each of them return smallest unique prefix of it. If such a unique prefix does not exist, return -1.

### sample input
```
words: ["cobra", "dog", "dove", "duck", "cobras", "fat", "cat", "cobrasake"]
```

### sample output
```
-1 dog dov du -1 f ca cobrasa
```

### Idea
The idea is to use a Trie with an attribute of frequency for each character. For a node if the corresponding character does not have more than 1 branch, then upto this character is the required answer, else if we reach the end of the word, there exists no such string, return -1.

### code
```java
import java.io.*;
import java.util.*;

class Node {

	Node[] child;
	int freq;

	Node () {
		this.child = new Node[26];
		this.freq = 0;
	}
}

class Trie {

	Node root;

	Trie () {
		this.root = new Node();
	}

	void insert (String word) {
		Node curr = root;
		for (int i=0; i<word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (curr.child[index] == null) {
				curr.child[index] = new Node();
			}
			curr.child[index].freq += 1;
			curr = curr.child[index];
		}
	}

	String searchPrefix (String word) {
		Node curr = root;
		String res = "";
		for (int i=0; i<word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (curr.child[index].freq != 1) {
				res += word.charAt(i);
				curr = curr.child[index];
			}
			else {
				res += word.charAt(i);
				return res;
			}
		}
		return "-1";
	}
}


class Solution {

	public static void main(String[] args) throws IOException {
		String[] words = {"cobra", "dog", "dove", "duck", "cobras", "fat", "cat", "cobrasake"};
		Trie trie = new Trie();
		for (String word: words) {
			trie.insert(word);
		}
		for (String word: words) {
			String res = trie.searchPrefix(word);
			System.out.print(res+" ");
		}
		System.out.println();
	}
}
```

### output
```
-1 dog dov du -1 f ca cobrasa
```
