import java.io.*;
import java.util.*;

class PrintReverseStack {

	static void printReverse(Stack<Integer> stack) {
		// base case
		if (stack.isEmpty()) {
			return;
		}
		int top = stack.pop();
		printReverse(stack);
		System.out.println(top);
	}

	// driver code
	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50); // 50 is at the top
		printReverse(stack);
	}

}
