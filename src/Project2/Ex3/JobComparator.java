package Project2.Ex3;

import java.util.Comparator;

public class JobComparator implements Comparator<Job> {
    @Override
    public int compare(Job a, Job b) {
        // Prioritize by deadline (smaller deadline first)
        int deadlineCompare = Integer.compare(a.getDeadline(), b.getDeadline());
        if (deadlineCompare != 0) {
            return deadlineCompare;
        }
        // If deadlines are equal, prioritize by arrival time (earlier first)
        return Integer.compare(a.getArrivalTime(), b.getArrivalTime());
    }
}