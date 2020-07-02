class SelectionSort {

	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	static void selectionSort(int[] arr, int n) {
		for (int i=0; i<n; i++) {
			int minIndex = i;
			for (int j=i+1; j<n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(arr, minIndex, i);
			}
		}

		// printing sorted array
		for (int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {13, 32, 5, 0, 34, 67};
		selectionSort(arr, arr.length);
	}
}
