# Segment Tree
Segment Tree is used for **fixed size Arrays** for mainly two types of operations/queries:
 - **Range Query** (Time Complexity: O(log n) typically)
 - **Update Query** (Time Complexity: O(log n) typically)
 
**Constructing a Segment Tree** requires
 - ϴ(n) preprocessing time
 - O(n) auxiliary space

## Representation
 - Internally it is represented as an array.
 - Each Node in the Segment Tree represents sum of elements in a particular range.
   - Root Node represents sum of all the elements. 
   - Leaf Nodes represent individual elements (except for psuedo Nodes)
 
## Construction
 - We create a root Node (*which will have the value as sum of all the elements*).
 - To get this value, we recursively call for left-half's root and right-half's root, (*because they will have the values of sum of left-half of elements and right-half of elements respectively*) and add the values.
 - we finish recursion, when we reach a Node, which has only one element in range, then we return that element.
 - We also want the Segment Tree to have [Binary Heap] property, so that we can call for left-child and right-child. That's why we need our Segment Tree to be a Complete Binary Tree. To make the Segment Tree a Complete Binary Tree:
   - we will create dummy Nodes, which are never going to be accessed.
   - **so, what should be the size of Segment Tree ?**
     - __size = (2*[2 power (Math.ceil(log₂ⁿ))]) + 1__, *where n = number of elements in Array*
     - size is also upper bounded by 4n, so we can loosely take it's size as 4n

## pseudo code
```
      Initialize tree[4n]
      Initialize values: 
        start of the segment (s = 0)
        end of the segment (e = n-1)
        segment tree index (i = 0)
      buildSegmentTree([ ]tree, [ ]array, s, e, i)
        // base case
        if (s == e)
           tree[i] = array[s]
           return tree[i]
        //recursive case
        mid = (s+e)/2
        tree[i] = buildSegmentTree(tree, array, s, mid, 2i+1) + buildSegmentTree(tree, array, mid+1, e, 2i+2)
        return tree[i]
```
