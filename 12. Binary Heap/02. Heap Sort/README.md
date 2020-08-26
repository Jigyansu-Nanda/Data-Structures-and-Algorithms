# Heap Sort
Heap Sort is mainly an improvisation over selection sort. In selection sort, we pick the largest element and put it in last place, then pick the second largest element and put it in second-last place and so on. To select the element, we perform a linear search. but in heap sort, we do the search in (log n) time with the help of heap data structure. Hence time complexity becomes n log n.
  - to sort in ascending order, we use binary max-heap data structure.
  - to sort in descending order, we use binary min-heap data structure.


## Time Complexity:
  - best case: O(n log n)
  - worst case: O(n log n)
  - average case: O(n log n)
