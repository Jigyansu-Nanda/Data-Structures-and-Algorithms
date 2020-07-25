# Generic Stack using LinkedList

```java
import java.io.*;
import java.util.*;

public class MyStack<T> {

	private LinkedList<T> list = new LinkedList<T>();

	// check whether stack is empty or not
	public boolean isEmpty() {
		return (list.size() == 0);
	}

	// current number of elements in stack
	public int size() {
		return list.size();
	}

	// push an item into stack
	public void push(T key) {
		list.addFirst(key);
	}

	// pop an item from stack
	public T pop() {
		return list.pollFirst();
	}

	// peek the top item of stack
	public T peek() {
		return list.peekFirst();
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
```

### output
```
false
3
B
B
2
```
