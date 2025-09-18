package Lession3.Ex3;

import java.util.Comparator;

public class MyPriorityQueue<T> {
    private T[] heap;
    private int size;
    private int capacity;
    private Comparator<T> comparator;

    @SuppressWarnings("unchecked")
    public MyPriorityQueue(int initialCapacity, Comparator<T> comparator) {
        this.capacity = initialCapacity;
        this.heap = (T[]) new Object[initialCapacity];
        this.size = 0;
        this.comparator = comparator;
    }

    public void enqueue(T item) {
        // Resize if needed
        if (size >= capacity) {
            resize(capacity * 2);
        }

        // Add to end
        heap[size] = item;
        size++;

        // Sift up
        siftUp(size - 1);
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (comparator.compare(heap[index], heap[parentIndex]) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }

        T result = heap[0];
        heap[0] = heap[size - 1];
        size--;

        // Resize down if needed
        if (size > 0 && size <= capacity / 4) {
            resize(capacity / 2);
        }

        if (!isEmpty()) {
            siftDown(0);
        }

        return result;
    }

    private void siftDown(int index) {
        int minIndex = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < size && comparator.compare(heap[leftChild], heap[minIndex]) < 0) {
            minIndex = leftChild;
        }

        if (rightChild < size && comparator.compare(heap[rightChild], heap[minIndex]) < 0) {
            minIndex = rightChild;
        }

        if (minIndex != index) {
            swap(index, minIndex);
            siftDown(minIndex);
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }
        return heap[0];
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

        T[] newHeap = (T[]) new Object[newCapacity];
        if (size >= 0) System.arraycopy(heap, 0, newHeap, 0, size);
        heap = newHeap;
        capacity = newCapacity;
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}