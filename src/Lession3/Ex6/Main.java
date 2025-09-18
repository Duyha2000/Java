package Lession3.Ex6;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Comparator<Integer> minComparator = (a, b) -> a - b;
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>(10, minComparator);

        System.out.println("=== Priority Queue Test (Min-Heap) ===");

        // Test 1: Initial state
        System.out.println("Initial state:");
        System.out.println("Size: " + pq.size());
        System.out.println("IsEmpty: " + pq.isEmpty());
        System.out.println();

        // Test 2: Enqueue elements
        System.out.println("Enqueuing: 5, 2, 8, 1");
        pq.enqueue(5);
        pq.enqueue(2);
        pq.enqueue(8);
        pq.enqueue(1);

        System.out.println("After enqueuing 4 elements:");
        System.out.println("Size: " + pq.size());
        System.out.println("Top: " + pq.peek());
        System.out.println();

        // Test 3: Dequeue twice
        System.out.println("Dequeueing 2 elements:");
        try {
            System.out.println("Dequeued: " + pq.dequeue()); // Should be 1
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("Dequeued: " + pq.dequeue()); // Should be 2
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();

        // Test 4: Check remaining state
        System.out.println("After dequeuing 2 elements:");
        System.out.println("Top: " + pq.peek());     // Should be 5
        System.out.println("Size: " + pq.size());    // Should be 2
        System.out.println("IsEmpty: " + pq.isEmpty()); // Should be false

        // Test 5: Complete the queue and empty it
        System.out.println("\n=== Completing Test ===");
        pq.enqueue(3);
        pq.enqueue(7);
        System.out.println("Enqueued 3 and 7. Current top: " + pq.peek());

        System.out.println("\nEmptying queue:");
        while (!pq.isEmpty()) {
            System.out.print("Dequeued: " + pq.dequeue() + " ");
        }
        System.out.println();
        System.out.println("Final size: " + pq.size());
        System.out.println("Final isEmpty: " + pq.isEmpty());
    }
}