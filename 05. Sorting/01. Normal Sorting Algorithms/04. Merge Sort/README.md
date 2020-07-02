# Merge Sort
It is a Divide & Conquer algorithm
 - First, divide the input array or list into two parts
 - Recursively sort these two parts
 - Merge these two parts
 
### pros
 - Stable Sorting Algorithm
 - **Time Complexity: ϴ(nlog n)**
 - For Linked List it is well-suited, as it works in O(1) auxiliary space for Linked Lists
 - Used in External Sorting. (parts of array can be brought in and sorted)
 
### cons
 - **Auxiliary Space: O(n)** *(There is a variation of Merge-Sort known as **Block Merge-Sort**, that works in O(1) extra space)*
 - In general, for Arrays, Quick Sort outperforms Merge Sort
