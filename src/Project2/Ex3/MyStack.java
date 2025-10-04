package Project2.Ex3;

import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] stack;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public MyStack(int initialCapacity) {
        this.capacity = initialCapacity;
        this.stack = (T[]) new Object[initialCapacity];
        this.size = 0;
    }

    public void push(T item) {
        if (size >= capacity) {
            resize(capacity * 2);
        }
        stack[size] = item;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        size--;
        T result = stack[size];
        stack[size] = null; // Help garbage collection
        return result;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        if (newCapacity < 1) newCapacity = 1;

        T[] newStack = (T[]) new Object[newCapacity];
        if (size >= 0) System.arraycopy(stack, 0, newStack, 0, size);
        stack = newStack;
        capacity = newCapacity;
    }
}