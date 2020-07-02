# Selection Sort
 - In selection sort, we find out the minimum element and put it in the first position, then find out the second-minimum element and put it in second position.
 - After i-th iteration, first i elements will be already sorted.
```
    void SelectionSort(arr, n)
    {
        for (int i=0; i<n-1; i++)
        {
            minIndex = i
            for (int j=i+1; j<n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j
                }
            }
            swap(arr[minIndex], arr[i])
        }
    }
```
 - **Time Complexity for Best, Worst & Average case is θ(n²)**
 - **At Worst Case, Selection Sort does n swaps, which is better than Bubble Sort, Insertion Sort**
 - **Pros**
   - It does less memory writes compared to Quick Sort, Merge Sort, Insertion Sort etc. Hence EEPROM ages well. *Cycle Sort is optimal, in terms of memory writes* 
   - It's the basic idea for Heap Sort
   - In-place sorting algorithm
 - **Cons**
   - Unstable sorting algorithm
     - [90₁, 80, 90₂, 25] ➤ [25, 80, 90₂, 90₁]
