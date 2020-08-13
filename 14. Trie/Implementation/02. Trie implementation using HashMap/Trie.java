import java.io.*;
import java.util.*;

class Trie {

	static class Node {
		HashMap<Character, Node> child = new HashMap<Character, Node>();
		boolean isEnd;
	}

	// search for a string in Trie
	static boolean search(Node root, String key) {
		Node curr = root;
		for (int i=0; i<key.length(); i++) {
			char c = key.charAt(i);
			if (!curr.child.containsKey(c)) {
				return false;
			}
			curr = curr.child.get(c);
		}
		return curr.isEnd;
	}

	// insert a string into Trie
	static void insert(Node root, String key) {
		Node curr = root;
		for (int i=0; i<key.length(); i++) {
			char c = key.charAt(i);
			if (curr.child.containsKey(c) == false) {
				curr.child.put(c, new Node());
			}
			curr = curr.child.get(c);
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
			char c = key.charAt(i);
			Node temp = delete(root.child.get(c), key, i+1);
			if (temp == null) {
				root.child.remove(c);
			}else {
				root.child.put(c, temp);
			}
			if (isEmpty(root) && root.isEnd == false) {
				root = null;
			}
			return root;
		}
	}

	// check whether node has all null children or not
	static boolean isEmpty(Node root) {
		return (root.child.size()==0);
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
		root = delete(root, "geeks", 0);
		System.out.println(search(root, "geek"));
		System.out.println(search(root, "jig"));
	}
}
