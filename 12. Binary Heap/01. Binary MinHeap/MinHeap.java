import java.io.*;
import java.util.*;


class MinHeap {

	int[] heap;
	int capacity;
	int size;

	MinHeap (int capacity) {
		this.capacity = capacity;
		this.heap = new int[capacity];
		this.size = 0;
	}

	int left (int index) {
		return (index << 1) + 1;
	}

	int right (int index) {
		return (index << 1) + 2;
	}

	int parent (int index) {
		return ((index - 1) >> 1);
	}

	void insert (int value) {
		if (size == capacity)
			return;
		heap[size] = value;
		int curr_index = size;
		size++;
		while (curr_index != 0 && heap[curr_index] < heap[parent(curr_index)]) {
			swap(curr_index, parent(curr_index));
			curr_index = parent(curr_index);
		}
	}

	void heapify (int index) {
		if (index >= size)
			return;
		int smallest = index;
		int leftChild = left(index);
		int rightChild = right(index);
		if (leftChild < size && heap[leftChild] < heap[smallest]) {
			smallest = leftChild;
		}
		if (rightChild < size && heap[rightChild] < heap[smallest]) {
			smallest = rightChild;
		}
		if (smallest != index) {
			swap(smallest, index);
			heapify(smallest);
		}
	}

	int extractMinimum () {
		if (size == 0)
			return Integer.MAX_VALUE;
		int min_value = heap[0];
		swap(0, size - 1);
		size--;
		heapify(0);
		return min_value;
	}

	void decreaseKey (int index, int new_value) {
		if (index >= size || index < 0)
			return;
		heap[index] = new_value;
		while (index != 0 && heap[index] < heap[parent(index)]) {
			swap(index, parent(index));
			index = parent(index);
		}
	}

	void delete (int index) {
		if (index < 0 || index >= size)
			return ;
		decreaseKey(index, Integer.MIN_VALUE);
		extractMinimum();
	}

	void buildHeap () {
		for (int i = (size - 2) / 2; i >= 0; i--) {
			heapify(i);
		}
	}

	void swap (int index1, int index2) {
		int tmp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = tmp;
	}

	public static void main(String[] args) {
		MinHeap obj = new MinHeap(5);
		obj.insert(12);
		obj.insert(23);
		obj.insert(3);
		obj.insert(-12);
		obj.insert(36);
		System.out.println(obj.extractMinimum());
		System.out.println(obj.extractMinimum());
		System.out.println(obj.extractMinimum());
		obj.decreaseKey(1, 30);
		System.out.println(obj.extractMinimum());
		System.out.println(obj.extractMinimum());
	}
}
