class MinHeap {

	int[] array;
	int size;
	int capacity;

	/* constructor */
	MinHeap (int capacity) {
		this.array = new int[capacity];
		this.size = 0;
		this.capacity = capacity;
	}

	/* left of Node at index i */
	static int left (int i) {return (2*i)+1;}

	/* right of Node at index i */
	static int right (int i) {return (2*i)+2;}

	/* parent of Node at index i */
	static int parent (int i) {return (i-1)/2;}

	/* insertion in heap */
	static void insert (int key) {
		if (size == capacity) {return ;}
		array[size] = key;
		size += 1;
		int i = size-1;
		while (i != 0 && array[i] < array[parent(i)]) {
			swap(array, i, parent(i));
			i = parent(i);
		}
	}

	/* Heapify */
	static void heapify (int index) {
		if (index >= size) {return ;}
		int smaller = index;
		int leftChild = left(index);
		int rightChild = right(index);
		if (array[leftChild] < array[smaller]) {
			smaller = leftChild;
		}
		if (array[rightChild] < array[smaller]) {
			smaller = rightChild;
		}
		while (smaller != index) {
			swap(array, smaller, index);
			heapify(smaller);
		}
	}

	/* Extract minimum */
	static int extractMin () {
		if (size == 0) {return Integer.MAX_VALUE;}
		int minValue = array[0];
		swap(array, 0, size-1);
		size--;
		heapify(0);
		return minValue;
	}

	/* Decrease Key */
	static void decreaseKey (int index, int value) {
		if (index >= size) {return ;}
		array[index] = value;
		while (index != 0 && array[index] < array[parent(index)]) {
			swap(array, index, parent(index));
			index = parent(index);
		}
	}

	/* Delete Key */
	static void deleteKey (int index) {
		decreaseKey(index, Integer.MIN_VALUE);
		extractMin();
	}

	/* Build heap */
	static void buildHeap () {
		for (int i = (size - 2) / 2; i >= 0; i--) {
			heapify(i);
		}
	}

	static void swap(int[] array, int index1, int index2) {
		int tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;
	}

	public static void main(String[] args) {
		/* driver code */
	}
}
