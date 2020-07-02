# Bubble Sort
 - In bubble sort, we compare adjacent elements and swap them,if the i+1-th element is smaller than i-th element.
 - Since no swap happens, if two items have same value, hence it is a **stable sorting algorithm**.
 - Bubble sort has multiple passes
    - In 1st pass, we send the largest element to the last position.
    - In 2nd pass, we send the second-largest element to the 2nd-last position.
    - In i-th pass, we send the i-th largest element to i-th last position.
    - That means, after (n-1)th pass, last (n-1) elements will be already sorted. Hence the array will be sorted. So, **total number of passes required are (n-1)**

**pseudo code 1**
```
    void BubbleSort(arr, n)
    {
        for (int i=0; i<n-1; i++) {                   // total (n-1) passes
            for (int j=0; j<n-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr[j], arr[j+1])
                }
            }
        }
    }
```
 - Total number of comparisons in the above approach is (n-1)².
 - We can reduce number of comparisons even further. Since after i-th pass, last i elements will be already sorted, so no need for further comparisons between them. So, we compare elements from 0 to n-i-1

**pseudo code 2**
```
    void BubbleSort(arr, n)
    {
        for (int i=0; i<n-1; i++) {                   // total (n-1) passes
            for (int j=0; j<n-i-1; j++) {             // after ith iteration, compare elements from 0 to n-i-1, because last i elements are sorted.
                if (arr[j] > arr[j+1]) {
                    swap(arr[j], arr[j+1])
                }
            }
        }
    }
```
 - In the above approach, for each i ranging from (0 to n-2), inner loop runs (n-i-1) times.
 - So, total number of comparisons become (n-1)+(n-2)+(n-3)+.....+1 = n(n-1)/2 
 - The issue with the above approach is, it does n(n-1)/2 comparisons, even for a sorted or almost sorted array. So we need to optimize it further.
 - For further optimization, we maintain a boolean variable (say, "swapped"). In each pass, we intialize this variable as *false*. Inside inner loop for each pass, if any swapping happens, we change this variable to *true*. After coming out of the inner loop, we check whether swapped is *true* or *false*. If it is false, that means, no swapping took place, i.e. array is already sorted, so we break out of the loop.

**pseudo code 3**
```
    void BubbleSort(arr, n)
    {
        for (int i=0; i<n-1; i++) {                   // total (n-1) passes
            swapped = false                           // initialize boolean variable as false in every pass
            for (int j=0; j<n-i-1; j++) {             // after ith iteration, compare elements from 0 to n-i-1, because last i elements are sorted.
                if (arr[j] > arr[j+1]) {
                    swap(arr[j], arr[j+1])
                    swapped = true
                }
            }
            if (swapped == false) {
                break                                 // break, as array must be already sorted
            }
        }
    }
```
 - The above approach does (n-1) comparisons in best case, when array is already sorted and n(n-1)/2 comparisons in worst case, when array is reverse-sorted.
 - **Best Case Time Complexity: O(n)**
 - **Worst Case Time Complexity: O(n²)**
