package Lession3.Ex3;


public class Job {
    private int id;
    private int deadline;
    private int arrivalTime;

    public Job(int id, int deadline, int arrivalTime) {
        this.id = id;
        this.deadline = deadline;
        this.arrivalTime = arrivalTime;
    }

    public int getId() {
        return id;
    }

    public int getDeadline() {
        return deadline;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Job " + id;
    }
}