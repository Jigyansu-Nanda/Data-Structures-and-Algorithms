class MergeSort {

	static void mergeSort(int[] arr, int l, int r) {
		if (r > l) 
		{
			int m = l+(r-l)/2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			merge(arr, l, m, r);
		}
	}

	static void merge(int[] arr, int l, int m, int r) {
		int n1 = m-l+1;
		int n2 = r-m;
		int[] left = new int[n1];
		int[] right = new int[n2];
		for (int i=0; i<n1; i++) {
			left[i] = arr[l+i];
		}
		for (int j=0; j<n2; j++) {
			right[j] = arr[m+1+j];
		}
		int i = 0;
		int j = 0;
		int index = l;
		while (i < n1 && j < n2)
		{
			if (left[i] <= right[j]) {
				arr[index] = left[i];
				i++;
				index++;
			}else {
				arr[index] = right[j];
				j++;
				index++;
			}
		}
		while (i < n1) {
			arr[index] = left[i];
			i++;
			index++;
		}
		while (j < n2) {
			arr[index] = right[j];
			j++;
			index++;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {13, 32, 5, 0, 34, 67};
		int n = arr.length;
		mergeSort(arr, 0, n-1);
		for (int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
