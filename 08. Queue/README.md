# Queue
Queue is a linear data structure,  which follows **FIFO(First In First Out)** order, in which the operations are performed.

## Application
 - Synchronization between slow and fast devices (used as a Buffer). i.e. Buffer for devices like Keyboard etc.
 - in Operating System:
    - Semaphor
    - FCFS Scheduling
    - Spooling in Printers
 - in Network:
    - Queues in Router/Switches
    - Mail Queue
    
## Implementation
 1. **using Circular Array**
 ```java
 class MyQueue {

    int capacity, front, size;
    int[] arr;

    MyQueue (int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.front = 0;
        this.size = 0;
    }

    boolean isEmpty () {
        return (size == 0);
    }

    boolean isFull () {
        return (size == capacity);
    }

    int getRear () {
        if (isEmpty()) {
            return 0;
        } else {
            return (front + size) % capacity;
        }
    }

    void enqueue (int x) {
        if (isFull()) {
            System.out.println("Queue is already full !");
            return;
        } else {
            int rear = getRear();
            arr[rear] = x;
            rear = (rear + 1) % capacity;
            size++;
        }
    }

    int dequeue () {
        if (isEmpty()) {
            return -1;
        } else {
            int tmp = arr[front];
            front = (front + 1) % capacity;
            size--;
            return tmp;
        }
    }

    int peek () {
        if (isEmpty()) {
            return -1;
        } else {
            return arr[front];
        }
    }

    int getSize () {
        return size;
    }

}
```

 2. **using Linked List**
 ```java
 class Node {

    int data;
    Node next;

    Node (int data) {
        this.data = data;
        this.next = null;
    }
}

class MyQueue {

    Node front;
    Node rear;
    int size;

    MyQueue () {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    void enqueue (int x) {
        Node temp = new Node(x);
        size++;
        /* if queue is empty */
        if (front == null) {
            front = temp;
            rear = temp;
            return ;
        } else {
            rear.next = temp;
            rear = temp;
        }
    }

    int dequeue () {
        /* queue is empty */
        if (front == null) {
            System.out.println("empty queue !!!");
            return -1;
        }
        int data = front.data;
        front = front.next;
        if (front == null) {rear = front;}
        size--;
        return data;
    }

    int peek () {
        if (isEmpty()) {
            System.out.println("empty queue !!!");
            return -1;
        }
        return front.data;
    }

    boolean isEmpty () {
        return (size == 0);
    }

    int getSize () {
        return size;
    }
}
 ```
