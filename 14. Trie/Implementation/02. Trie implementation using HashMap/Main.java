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

}

class Main {

	public static void main(String[] args) throws IOException {
		String[] dictionary = {"bat", "but", "geek", "geeks", "cat", "cut", "zoo", "batman"};
		Trie trie = new Trie();
		for (String word: dictionary) {
			trie.insert(word);
		}
	}

}
