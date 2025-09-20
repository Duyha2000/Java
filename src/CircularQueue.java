import java.util.NoSuchElementException;

public class CircularQueue<T> {
    // ← FIELDS: Array to store elements + circular pointers + size tracking
    private T[] queue;
    private int front = 0;        // ← POINTS TO HEAD (element to dequeue)
    private int rear = 0;         // ← POINTS TO TAIL (position to enqueue next)
    private int size = 0;         // ← TRACKING ACTUAL NUMBER OF ELEMENTS
    private int capacity;         // ← FIXED MAXIMUM SIZE


    // ← CONSTRUCTOR: Initialize circular queue with given capacity
    @SuppressWarnings("unchecked")
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];  // Create the queue array
    }


    // ← ENQUEUE: Add element to rear with circular wrap-around
    public void enqueue(T item) {
        // TODO: Check if queue is full using size tracking
        // HINT: if (isFull()) throw new IllegalStateException("Queue is full");
        if (isFull()) {
            throw new IllegalStateException("queue is full");
        }

        // TODO: Add item at current rear position
        // HINT: queue[rear] = item;
        queue[rear] = item;
        rear = (rear + 1) % capacity;
        size++;
    }

    // ← DEQUEUE: Remove and return element from front with circular wrap-around
    public void dequeue() {
        // TODO: Check if queue is empty using size tracking
        // HINT: if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        // TODO: Get element at current front position
        // HINT: T item = queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        size--;
    }


    // ← PEEK: View front element without removing it
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        // TODO: Return front element WITHOUT moving pointers
        return queue[front];
    }


    // ← IS EMPTY: Check if queue contains no elements
    private boolean isEmpty() {
        return size == 0;  // ← RELIES ON SIZE COUNTER
    }


    // ← IS FULL: Check if queue has reached maximum capacity
    private boolean isFull() {
        // TODO: Return true if maximum elements reached
        return size == capacity;
    }


    // ← SIZE: Return current number of elements
    public int size() {
        return size;
    }


    // ← MAIN: Test circular queue implementation
    public static void main(String[] args) {
        System.out.println("\n=== COMPLETE CYCLE TEST ===");
        CircularQueue<String> fullTest = new CircularQueue<>(3);
        fullTest.enqueue("A");
        fullTest.enqueue("B");
        fullTest.enqueue("C");
        System.out.println("Full: " + fullTest.size());  // 3

        fullTest.dequeue();  // Remove A
        fullTest.enqueue("D");  // Wrap around to index 0
        System.out.println("After dequeue A, enqueue D: Size=" + fullTest.size());
        System.out.println("Elements: " + fullTest.peek() + " → D → C");  // B → D → C

    }
}
