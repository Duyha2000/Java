package Lession3.Ex2;

import java.util.Comparator;

public class Main {
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
