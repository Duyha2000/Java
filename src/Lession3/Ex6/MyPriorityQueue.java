package Lession3.Ex6;

import java.util.Comparator;

public class MyPriorityQueue<T> {
    private T[] heap;
    private int size;
    private int capacity;
    private Comparator<T> comparator;

    @SuppressWarnings("unchecked")
    public MyPriorityQueue(int capacity, Comparator<T> comparator) {
        this.capacity = capacity;
        this.heap = (T[]) new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    public void enqueue(T item) {
        // Check for overflow (optional - could resize instead)
        if (size >= capacity) {
            throw new RuntimeException("Priority queue overflow: Cannot enqueue to full queue");
        }

        // Add item at the end
        heap[size] = item;
        size++;

        // Sift up to maintain heap property
        siftUp(size - 1);
    }

    private void siftUp(int index) {
        // While not at root and parent is greater than current (min-heap)
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            // If current item has higher priority (smaller) than parent, swap
            if (comparator.compare(heap[index], heap[parentIndex]) < 0) {
                swap(index, parentIndex);
                index = parentIndex; // Continue sifting up
            } else {
                break; // Heap property satisfied
            }
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }

        // Save root (highest priority item)
        T result = heap[0];

        // Move last item to root
        heap[0] = heap[size - 1];
        size--;

        // Sift down to restore heap property
        if (!isEmpty()) {
            siftDown(0);
        }

        return result;
    }

    private void siftDown(int index) {
        int parentIndex = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        // Find smallest among parent, left child, and right child
        if (leftChild < size && comparator.compare(heap[leftChild], heap[parentIndex]) < 0) {
            parentIndex = leftChild;
        }

        if (rightChild < size && comparator.compare(heap[rightChild], heap[parentIndex]) < 0) {
            parentIndex = rightChild;
        }

        // If a child has higher priority, swap and continue
        if (parentIndex != index) {
            swap(index, parentIndex);
            siftDown(parentIndex);
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

    // Helper method to swap elements
    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}