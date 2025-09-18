package Lession3.Ex1;

import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] stack;
    private int top;
    private int capacity;

    @SuppressWarnings("unchecked")
    public MyStack(int initialCapacity) {
        this.capacity = initialCapacity;
        this.stack = (T[]) new Object[initialCapacity];
        this.top = -1;
    }

    public void push(T item) {
        // Check if stack is full
        if (top == capacity - 1) {
            // Resize: double the capacity
            int newCapacity = capacity * 2;
            @SuppressWarnings("unchecked")
            T[] newStack = (T[]) new Object[newCapacity];

            // Copy existing elements
            if (top + 1 >= 0) System.arraycopy(stack, 0, newStack, 0, top + 1);

            // Update references
            this.stack = newStack;
            this.capacity = newCapacity;
        }

        // Add new item
        stack[++top] = item;
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top--];
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}
