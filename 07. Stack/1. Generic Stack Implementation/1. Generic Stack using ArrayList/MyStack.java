import java.io.*;
import java.util.*;

public class MyStack<T> {

	private ArrayList<T> arr = new ArrayList<T>();
	private int top = -1;

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
		arr.add(key);
		top++;
	}

	// pop an item from stack
	public T pop() {
		if (top == -1) {
			return null;
		}
		else {
			T val = arr.get(top);
			arr.remove(top);
			top--;
			return val;
		}
	}

	// peek the top item of stack
	public T peek() {
		if (top == -1) {
			return null;
		}
		else {
			return arr.get(top);
		}
	}

	// driver code
	public static void main(String[] args) throws IOException {
		MyStack<String> stack = new MyStack<String>();
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
