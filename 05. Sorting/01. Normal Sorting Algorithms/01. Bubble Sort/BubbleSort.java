import java.io.*;

class BubbleSort {

	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	static void bubbleSort(int[] arr, int n) {
		for (int i=0; i<n-1; i++) {
			boolean swapped = false;
			for (int j=0; j<n-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
					swapped = true;
				}
			}
			if (swapped == false) {break;}
		}
		for (int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		int[] arr = {13, 32, 5, 0, 34, 67};
		bubbleSort(arr, arr.length);
	}
}
