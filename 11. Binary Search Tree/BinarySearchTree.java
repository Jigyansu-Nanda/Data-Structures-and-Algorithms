import java.util.*;

class BinarySearchTree {

	static class Node {
		int data;
		Node left;
		Node right;
		// constructor
		Node (int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	// inorder traversal
	static void inorder(Node root) {
		if (root != null)
		{
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}

	// iterative search
	static boolean iterativeSearch(Node root, int key) {
		while (root != null) {
			if (root.data == key) {return true;}
			else if (root.data > key) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return false;
	}

	// recursive search
	static boolean recursiveSearch(Node root, int key) {
		if (root == null) {return false;}
		if (root.data == key) {return true;}
		if (root.data < key) {
			return recursiveSearch(root.right, key);
		} else {
			return recursiveSearch(root.left, key);
		}
	}

	// recursive insertion of a Node into BST
	static Node recursiveInsert(Node root, int key) {
		// empty BST, inserted Node becomes root
		if (root == null) {
			Node temp = new Node(key);
			return temp;
		}
		// if key-Node already exists
		if (root.data == key) {
			return root;
		}
		// if key is less than root's value
		if (key < root.data) {
			root.left = recursiveInsert(root.left, key);
		} else {
			root.right = recursiveInsert(root.right, key);
		}
		return root;
	}

	// iterative insertion of a Node into BST
	static Node iterativeInsert(Node root, int key) {
		Node temp = new Node(key);
		Node prev = null;
		Node curr = root;
		while (curr != null) {
			prev = curr;
			if (key < curr.data) {
				curr = curr.left;
			} else if (key > curr.data) {
				curr = curr.right;
			} else {
				return root;
			}
		}
		if (prev == null) {
			return temp;
		}
		if (prev.left == null) {
			prev.left = temp;
		} else if (prev.right == null) {
			prev.right = temp;
		}
		return root;
	}

	// inorder successor of a Node
	static Node getInorderSuccessor(Node root) {
		Node curr = root.right;
		while (curr!=null && curr.left!=null) {
			curr = curr.left;
		}
		return curr;
	}

	// deletion of a Node in BST
	static Node delete(Node root, int key) {
		// if empty BST, return null
		if (root == null) {return null;}
		if (root.data > key) {
			root.left = delete(root.left, key);
			return root;
		}
		if (root.data < key) {
			root.right = delete(root.right, key);
			return root;
		}
		else  // Node found
		{
			// if it's a leaf Node or parent of single leaf Node
			if (root.left == null) {return root.right;}
			if (root.right == null) {return root.left;}
			else
			{
				Node inorderSuccessor = getInorderSuccessor(root);
				root.data = inorderSuccessor.data;
				root.right = delete(root.right, inorderSuccessor.data);
			}
			return root;
		}
	}

	public static void main(String[] args) {
		// driver code
		Node root = new Node(50);
		root.left = new Node(30);
		root.right = new Node(70);
		root.left.left = new Node(10);
		root.left.right = new Node(40);
		root.right.left = new Node(60);
		root.right.right = new Node(80);
		inorder(root);
		System.out.println();
		root = recursiveInsert(root, 35);
		inorder(root);
		System.out.println();
		root = iterativeInsert(root, 55);
		inorder(root);
		System.out.println();
		root = delete(root, 80);
		inorder(root);
		System.out.println();
	}
}
