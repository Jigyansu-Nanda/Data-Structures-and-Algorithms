## problem statement
Given a stack, sort the stack such that minimum element stays at bottom of the stack.

```java
import java.io.*;
import java.util.*;

class SortStack {

	static void Sort(Stack<Integer> stack) {
		// base case
		if (stack.isEmpty()) {
			return;
		}
		int top = stack.pop();
		Sort(stack);
		sortedInsert(stack, top);
	}

	static void sortedInsert(Stack<Integer> stack, int key) {
		// base case
		if (stack.isEmpty()) {
			stack.push(key);
		}
		// recursive case
		else {
			if (stack.peek() > key) {
				int top = stack.pop();
				sortedInsert(stack, key);
				stack.push(top);
			}
			else {
				stack.push(key);
			}
		}
	}

	// driver code
	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(23);
		stack.push(3);
		stack.push(12);
		stack.push(8);
		stack.push(67);
		Sort(stack);
		// printing sorted stack
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
```

### output
```
67
23
12
8
3
```
