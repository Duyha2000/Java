package Lession3;

import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize the stack with the given initial capacity
    @SuppressWarnings("unchecked")
    public MyStack(int initialCapacity) {
        this.capacity = initialCapacity;  // Set the initial capacity
        this.stack = (T[]) new Object[initialCapacity];  // Create the stack array
        this.top = -1;  // Initialize the top index as -1 (indicating an empty stack)
    }

    // Method to push an item onto the stack
    public void push(T item) {
        // Check if the stack is full, and resize if necessary
        if (top == capacity - 1) {
            resize(capacity * 2);  // Double the capacity if full
        }
        stack[++top] = item;  // Add the item to the stack and increment the top index
    }

    // Method to pop an item from the stack
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();  // Throw an exception if the stack is empty
        }
        T item = stack[top];  // Store the item to return
        stack[top--] = null;  // Remove the item and decrement the top index
        return item;  // Return the popped item
    }

    // Method to peek at the top item without removing it
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();  // Throw an exception if the stack is empty
        }
        return stack[top];  // Return the top item without removing it
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;  // Return true if the top index is -1 (stack is empty)
    }

    // Method to return the current size of the stack
    public int size() {
        return top + 1;  // Return the number of elements in the stack
    }

    // Helper method to resize the stack when full
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        capacity = newCapacity;  // Update the capacity to the new size
        T[] newStack = (T[]) new Object[capacity];  // Create a new array with the new capacity
        System.arraycopy(stack, 0, newStack, 0, size());  // Copy the existing elements to the new array
        stack = newStack;  // Update the stack reference to the new array
    }

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>(5);
        // TODO: Push 6 elements, pop 3, print top and size

    }
}

