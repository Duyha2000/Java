package Lession3.Ex5;

import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] stack;
    private int top;
    private int capacity;

    @SuppressWarnings("unchecked")
    public MyStack(int capacity) {
        this.capacity = capacity;
        this.stack = (T[]) new Object[capacity];
        this.top = -1;
    }

    public void push(T item) {
        // Check for overflow
        if (top >= capacity - 1) {
            throw new RuntimeException("Stack overflow: Cannot push to full stack");
        }

        // Increment top and add item
        top++;
        stack[top] = item;
    }

    public T pop() {
        // Check for underflow
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        // Get the top item, remove it, and decrement top
        T item = stack[top];
        stack[top] = null; // Help garbage collection
        top--;
        return item;
    }

    public T peek() {
        // Check for underflow
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        // Return top item without removing it
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1; // Number of elements is top + 1 (since top starts at -1)
    }
}