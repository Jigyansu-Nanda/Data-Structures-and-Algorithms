# Binary Search Tree
Binary Search Tree is a node-based binary tree data structure which has the following properties:
 - The left subtree of a node contains only nodes with keys lesser than the node’s key.
 - The right subtree of a node contains only nodes with keys greater than the node’s key.
 - The left and right subtree each must also be a binary search tree.
 
 
## Applications of Binary Search Tree
 - To maintain a sorted stream of data or sorted set of data
 - To implement a Doubly Ended Priority Queue
 - To keep track of smaller/greater/floor/ceil value for inputs in a stream
 
## Construction

```java
static class Node {
	int data;
	Node left;
	Node right;
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
