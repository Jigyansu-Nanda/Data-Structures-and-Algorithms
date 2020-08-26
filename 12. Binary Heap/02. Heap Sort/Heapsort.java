import java.io.*;
import java.util.*;

class Heapsort {

	static void swap (int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}

	static void buildMaxHeap (int[] arr, int n) {
		for (int i=(n-2)/2; i>=0; i--) {
			maxHeapify(arr, n, i);
		}
	}

	static void maxHeapify (int[] arr, int n, int i) {
		int larger = i;
		int leftChild = (2*i)+1;
		int rightChild = (2*i)+2;
		if (leftChild < n && arr[larger] < arr[leftChild]) {
			larger = leftChild;
		}
		if (rightChild < n && arr[larger] < arr[rightChild]) {
			larger = rightChild;
		}
		if (larger != i) {
			swap(arr, larger, i);
			maxHeapify(arr, n, larger);
		}
	}

	static void HeapSort (int[] arr, int n) {
		buildMaxHeap(arr, n);
		for (int i=n-1; i>=1; i--) {
			swap(arr, 0, i);
			maxHeapify(arr, i, 0);
		}
	}

	public static void main(String[] args) throws IOException {
		/* driver code */
	}
}
