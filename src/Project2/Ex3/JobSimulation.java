package Project2.Ex3;

import java.util.ArrayList;
import java.util.List;

public class JobSimulation {
    private MyPriorityQueue<Job> priorityQueue;
    private MyStack<Job> lateJobs;
    private Job[] jobs;

    public JobSimulation(Job[] jobs) {
        JobComparator comparator = new JobComparator();
        this.priorityQueue = new MyPriorityQueue<>(jobs.length, comparator);
        this.lateJobs = new MyStack<>(jobs.length);
        this.jobs = jobs;
    }

    public void simulate() {
        int currentMinute = 0;
        int jobIndex = 0; // Index of next job to release

        System.out.println("Starting job simulation...");

        // Continue until all jobs are released and processed
        while (jobIndex < jobs.length || !priorityQueue.isEmpty()) {

            // Release new jobs that arrive at this minute
            while (jobIndex < jobs.length && jobs[jobIndex].getArrivalTime() == currentMinute) {
                priorityQueue.enqueue(jobs[jobIndex]);
                jobIndex++;
            }

            // Process one job if available
            if (!priorityQueue.isEmpty()) {
                Job job = priorityQueue.dequeue();
                System.out.println("Minute " + currentMinute + ": Processed " + job);

                // Check if job was late
                if (currentMinute > job.getDeadline()) {
                    lateJobs.push(job);
                }
            }

            currentMinute++;
        }

        printLateJobs();
    }

    private void printLateJobs() {
        System.out.print("Late Jobs: ");
        if (lateJobs.isEmpty()) {
            System.out.println("None");
        } else {
            List<Job> lateJobList = new ArrayList<>();
            while (!lateJobs.isEmpty()) {
                lateJobList.add(lateJobs.pop());
            }

            // Print in reverse order (most recently added first)
            for (int i = lateJobList.size() - 1; i >= 0; i--) {
                System.out.print(lateJobList.get(i));
                if (i > 0) System.out.print(", ");
            }
            System.out.println();
        }
    }
}