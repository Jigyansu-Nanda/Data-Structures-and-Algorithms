# Binary Heap
Binary Heap is a **Complete Binary Tree**, stored and represented as an Array. A **Complete Binary Tree** means it's all levels are completely filled, except possibly the last level. And the last level has to be filled from left-to-right (otherwise it will not be a Complete Binary Tree). In Array representation of Heap, these following properties hold:
 - Left of Node at index i : **left(i) = 2i + 1**
 - Right of Node at index i : **right(i) = 2i + 2**
 - Parent of Node at index i : **parent(i) = (i - 1)/2**

## Advantages of Array representation
 - Random Access possible 
 - Cache-friendly (Locality of reference)
 - Height of Complete Binary Tree is minimum posible (*hence some operations will have time complexity O(h)/O(log n)*)

## Types
There are two types of Heap data structure. They are following:
 - **Min Heap**
    - Highest priority item is assigned lowest value.
    - Every Node has value smaller than it's Descendants
 - **Max Heap**
    - Highest priority item is assigned highest value.
    - Every Node has value higher than it's Descendants

## Use
 - Heap Sort
 - Implementation of Priority Queue
