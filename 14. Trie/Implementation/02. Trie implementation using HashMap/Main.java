import java.io.*;
import java.util.*;

class Node {

	HashMap<Character, Node> child;
	boolean isEnd;

	Node () {
		this.child = new HashMap<Character, Node>();
		this.isEnd = false;
	}
}


class Trie {

	Node node;

	Trie () {
		this.node = new Node();
	}

	boolean search (String word) {
		Node curr = node;
		for (int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if (curr.child.containsKey(c) == false) {
				return false;
			}
			curr = curr.child.get(c);
		}
		return curr.isEnd;
	}

	void insert (String word) {
		Node curr = node;
		for (int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if (curr.child.containsKey(c) == false) {
				curr.child.put(c, new Node());
			}
			curr = curr.child.get(c);
		}
		curr.isEnd = true;
	}

	boolean isEmpty (Node node) {
		return (node.child.size() == 0);
	}

	void delete (String word) {
		node = deleteRec(node, word, 0);
	}

	Node deleteRec (Node node, String word, int l) {
		if (node == null) {return null;}
		if (l == word.length()) {
			node.isEnd = false;
			if (isEmpty(node)) {return null;}
			return node;
		}
		char c = word.charAt(l);
		Node temp = deleteRec(node.child.get(c), word, l+1);
		if (temp == null) {
			node.child.remove(c);
		}
		else {
			node.child.put(c, temp);
		}
		if (isEmpty(node) && node.isEnd == false) {
			return null;
		}
		return node;
	}
}

class Main {

	public static void main(String[] args) throws IOException {
		String[] dictionary = {"bat", "but", "geek", "geeks", "cat", "cut", "zoo", "batman"};
		Trie trie = new Trie();
		for (String word: dictionary) {
			trie.insert(word);
		}
		System.out.println(trie.search("bat"));
		trie.delete("batman");
		System.out.println(trie.search("batman"));
		System.out.println(trie.search("bat"));
		trie.insert("batman");
		trie.delete("bat");
		System.out.println(trie.search("batman"));
	}

}


