# Insertion Sort
 - In insertion sort, we start from 2nd element and we maintain 0 to (i-1)th elements sorted. *(they might not be in their final position, but they are sorted)*.
 - After i-th iteration, first i elements will be already sorted.
 - For i-th element, we start from (i-1)-th element and shift all elements (that are greater than key value) to right, then we insert key at (j+1)-th position
```
   void InsertionSort(arr, n)
   {
      for (int i=1; i<n; i++) {
          key = arr[i]
          j = i-1
          while (j >= 0 and arr[j] > key)
          {
              arr[j+1] = arr[j]
              j = j-1
          }
          arr[j+1] = key
      }
   }
```
 - **Best Case Time Complexity: (n-1) comparisons = O(n)**, when array is already sorted, *while loop* will never be executed.
 - **Worst Case Time Complexity: n(n-1)/2 comparisons = O(n²)**, when array is reverse-sorted.
 - It is a stable sorting algorithm.
**When array is sorted or almost-sorted, Insertion-Sort is preferred, because it takes linear time**
