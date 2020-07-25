import java.io.*;
import java.util.*;

class ReverseStack {

	static void Reverse(Stack<Integer> stack) {
		// base case
		if (stack.isEmpty()) {
			return;
		}
		int top = stack.pop();
		Reverse(stack);
		insertAtBottom(stack, top);
	}

	static void insertAtBottom(Stack<Integer> stack, int key) {
		// base case
		if (stack.isEmpty()) {
			stack.push(key);
			return;
		}
		int top = stack.pop();
		insertAtBottom(stack, key);
		stack.push(top);
	}

	// driver code
	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50); // 50 is at the top
		Reverse(stack);
		// printing reversed stack
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
