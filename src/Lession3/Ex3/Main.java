package Lession3.Ex3;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Test 1: Priority Queue with integers
        System.out.println("=== Priority Queue Test ===");
        Comparator<Integer> minComparator = (a, b) -> a - b;
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>(5, minComparator);

        // Enqueue 6 integers
        pq.enqueue(5);
        pq.enqueue(2);
        pq.enqueue(8);
        pq.enqueue(1);
        pq.enqueue(9);
        pq.enqueue(3);

        System.out.println("Queue size: " + pq.size());
        System.out.println("Top element: " + pq.peek());

        // Dequeue 3
        System.out.print("Dequeued: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(pq.dequeue() + " ");
        }
        System.out.println();
        System.out.println("Remaining size: " + pq.size());
        System.out.println("New top: " + pq.peek());
        System.out.println();

        // Test 2: Job Simulation
        System.out.println("=== Job Simulation Test ===");

        // Create sample jobs: id, deadline, arrivalTime
        Job[] jobs = {
                new Job(1, 2, 1),  // arrives at minute 1, deadline 2
                new Job(2, 1, 0),  // arrives at minute 0, deadline 1
                new Job(3, 3, 3),  // arrives at minute 3, deadline 3
                new Job(4, 2, 2)   // arrives at minute 2, deadline 2
        };

        JobSimulation simulation = new JobSimulation(jobs);
        simulation.simulate();
    }
}