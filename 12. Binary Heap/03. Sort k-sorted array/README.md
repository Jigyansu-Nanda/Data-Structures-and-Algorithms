# Sort a K-sorted array
**K-sorted array**: An element at index i will be present between the indexes i-k to i+k in the sorted array.

## expected time complexity: O(n log k)

### code
```java
import java.io.*;
import java.util.*;

class Heap {

	static void KSort(int[] arr, int n, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i=0; i<=k; i++) {
			pq.add(arr[i]);
		}
		int index = 0;
		for (int i=k+1; i<n; i++) {
			arr[index++] = pq.poll();
			pq.add(arr[i]);
		}
		while (pq.isEmpty() == false) {
			arr[index++] = pq.poll();
		}
	}

	public static void main(String[] args) throws IOException {
		File text = new File("input.txt");
		Scanner sc = new Scanner(text);
		// Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			for (int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			KSort(arr, n, k);
			for (int x: arr) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
```

### sample input
```
2
6 2
9 8 7 18 19 17
8 4
10 9 7 8 4 70 50 60
```

### sample output
```
7 8 9 17 18 19 
4 7 8 9 10 50 60 70 
```
