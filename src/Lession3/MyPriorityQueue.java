package Lession3;

import java.util.Comparator;
import java.util.EmptyStackException;

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
        // Check if heap is full and resize if needed
        if (size == capacity) {
            resize(capacity * 2);
        }

        // Add item at the end
        heap[size] = item;
        size++;

        // Sift up to maintain heap property
        siftUp(size - 1);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        // Get the minimum element (root)
        T min = heap[0];

        // Move the last element to root
        heap[0] = heap[size - 1];
        size--;

        // Resize down if necessary (optional optimization)
        if (size > 0 && size == capacity / 4) {
            resize(capacity / 2);
        }

        // Sift down to maintain heap property
        if (size > 0) {
            siftDown(0);
        }

        return min;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return heap[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // Helper method to sift up
    private void siftUp(int index) {
        // While not at root and parent is greater than current
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (comparator.compare(heap[parentIndex], heap[index]) <= 0) {
                break; // Heap property maintained
            }

            // Swap with parent
            swap(parentIndex, index);
            index = parentIndex;
        }
    }

    // Helper method to sift down
    private void siftDown(int index) {
        int minIndex = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        // Find the smallest among current, left child, and right child
        if (leftChild < size && comparator.compare(heap[leftChild], heap[minIndex]) < 0) {
            minIndex = leftChild;
        }

        if (rightChild < size && comparator.compare(heap[rightChild], heap[minIndex]) < 0) {
            minIndex = rightChild;
        }

        // If smallest is not current, swap and continue
        if (minIndex != index) {
            swap(index, minIndex);
            siftDown(minIndex);
        }
    }

    // Helper method to swap elements
    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Helper method to resize the array
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newHeap = (T[]) new Object[newCapacity];
        if (size >= 0) System.arraycopy(heap, 0, newHeap, 0, size);
        this.heap = newHeap;
        this.capacity = newCapacity;
    }

    public static void main(String[] args) {
        Comparator<Integer> minComparator = Comparator.comparingInt(a -> a);
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>(5, minComparator);

        // Enqueue 6 integers (will trigger resize on the 6th enqueue)
        System.out.println("Enqueuing elements:");
        pq.enqueue(5);
        pq.enqueue(2);
        pq.enqueue(8);
        pq.enqueue(1);
        pq.enqueue(4);
        pq.enqueue(3);

        // Dequeue 3 elements
        System.out.println("\nDequeuing 3 elements:");
        System.out.println("Dequeued: " + pq.dequeue()); // 1
        System.out.println("Dequeued: " + pq.dequeue()); // 2
        System.out.println("Dequeued: " + pq.dequeue()); // 3

        // Print top element and size
        System.out.println("\nTop: " + pq.peek()); // 4
        System.out.println("Size: " + pq.size());  // 3
    }
}
