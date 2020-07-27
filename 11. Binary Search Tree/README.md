# Binary Search Tree
Binary Search Tree is a node-based binary tree data structure which has the following properties:
 - The left subtree of a node contains only nodes with keys lesser than the node’s key.
 - The right subtree of a node contains only nodes with keys greater than the node’s key.
 - The left and right subtree each must also be a binary search tree.
 
## Construction

```java
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
```

## Methods implemented:

 - Search in BST
    - Recursive
    - Iterative
 - Insert Node in BST
    - Recursive
    - Iterative
 - Deletion of Node (inorder successor)
    - Recursive
 - Inorder Traversal
