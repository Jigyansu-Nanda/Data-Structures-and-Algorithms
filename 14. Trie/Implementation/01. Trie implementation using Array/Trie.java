import java.io.*;
import java.util.*;

class Trie {

	static class Node {
		Node[] child = new Node[256];
		boolean isEnd;
	}

	// search for a string in Trie
	static boolean search(Node root, String key) {
		Node curr = root;
		for (int i=0; i<key.length(); i++) {
			int index = (int) key.charAt(i);
			if (curr.child[index] == null) {
				return false;
			}
			curr = curr.child[index];
		}
		return curr.isEnd;
	}

	// insert a string into Trie
	static void insert(Node root, String key) {
		Node curr = root;
		for (int i=0; i<key.length(); i++) {
			int index = (int) key.charAt(i);
			if (curr.child[index] == null) {
				curr.child[index] = new Node();
			}
			curr = curr.child[index];
		}
		curr.isEnd = true;
	}

	// delete a string from Trie
	static Node delete(Node root, String key, int i) {
		// key doesn't exist
		if (root == null) {
			return null;
		}
		// end of the string
		if (i == key.length()) {
			root.isEnd = false;
			if (isEmpty(root)) {
				root = null;
			}
			return root;
		}
		// else recursively call delete
		else {
			int index = (int) key.charAt(i);
			root.child[index] = delete(root.child[index], key, i+1);
			if (isEmpty(root) && root.isEnd == false) {
				root = null;
			}
			return root;
		}
	}

	// check whether node has all null children or not
	static boolean isEmpty(Node root) {
		for (int i=0; i<256; i++) {
			if (root.child[i] != null) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// driver code
		Node root = new Node();
		insert(root, "bat");
		insert(root, "batman");
		insert(root, "jig");
		insert(root, "geek");
		insert(root, "geeks");
		insert(root, "jigyansu");
		root = delete(root, "bat", 0);
		System.out.println(search(root, "bat"));
		System.out.println(search(root, "batman"));
		root = delete(root, "batman", 0);
		System.out.println(search(root, "batman"));
		root = delete(root, "jig", 0);
		System.out.println(search(root, "jigyansu"));
	}
}
