import java.io.*;
import java.util.*;

public class MyStack<T> {

	private T[] arr;
	private int top = -1;

	@SuppressWarnings("unchecked")
	MyStack(int capacity) {
		this.arr = (T[]) new Object[capacity];
		this.top = -1;
	}

	// check whether stack is empty or not
	public boolean isEmpty() {
		return (top == -1);
	}

	// current number of elements in stack
	public int size() {
		return top+1;
	}

	// push an item into stack
	public void push(T key) {
		if (top+1 == arr.length) {
			System.out.println("Stack is full!");
			return;
		}
		else {
			top++;
			arr[top] = key;
		}
	}

	// pop an item from stack
	public T pop() {
		if (top == -1) {
			return null;
		}
		else {
			top--;
			return arr[top+1];
		}
	}

	// peek the top item of stack
	public T peek() {
		if (top == -1) {
			return null;
		}
		else {
			return arr[top];
		}
	}

	// driver code
	public static void main(String[] args) throws IOException {
		MyStack<String> stack = new MyStack<String>(5);
		stack.push("T");
		stack.push("A");
		stack.push("B");
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.size());
	}

}
