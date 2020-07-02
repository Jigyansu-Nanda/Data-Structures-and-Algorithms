class InsertionSort {

	static void insertionSort(int[] arr, int n) {
		for (int i=1; i<n; i++) {
			int key = arr[i];
			int j = i-1;
			while (j>=0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}

		// printing sorted array
		for (int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {13, 32, 5, 0, 34, 67};
		insertionSort(arr, arr.length);
	}
}
