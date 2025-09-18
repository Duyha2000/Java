package Lession3;

import java.util.NoSuchElementException;

public class CircularQueue<T> {
    private T[] queue;
    private int front = 0;
    private int rear = 0;
    private int size = 0;  // ← CẦN size để track số elements
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];  // Create the queue array
    }

    public void enqueue(T item) {
        if (isFull()) {  // ← PHỨC TẠP HƠN: check size, không phải rear
            throw new IllegalStateException("Queue full");
        }
        queue[rear] = item;
        rear = (rear + 1) % capacity;  // ← CORE DIFFERENCE: MODULO OPERATION!
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue empty");
        }
        T item = queue[front];
        front = (front + 1) % capacity;  // ← CORE DIFFERENCE: MODULO OPERATION!
        size--;
        return item;
    }

    private boolean isFull() {
        return size == capacity;
    }  // ← Dựa vào size

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue empty");
        }
        return queue[front];  // ← XEM ĐẦU HÀNG KHÔNG LẤY
    }

    private boolean isEmpty() {
        return size == 0;
    }        // ← Dựa vào size

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CircularQueue<Integer> cq = new CircularQueue<>(5);

        // Test enqueue/dequeue
        for (int i = 1; i <= 5; i++) {
            cq.enqueue(i);
        }
        System.out.println("After enqueue 1-5: " + cq.size()); // 5

        System.out.println("Dequeue: " + cq.dequeue()); // 1
        System.out.println("Dequeue: " + cq.dequeue()); // 2

        cq.enqueue(6);
        cq.enqueue(7);
        System.out.println("Peek: " + cq.peek()); // 3
        System.out.println("Size: " + cq.size()); // 5

        // Test full
        try {
            cq.enqueue(8);
        } catch (IllegalStateException e) {
            System.out.println("Expected: " + e.getMessage()); // Queue full
        }
    }
}