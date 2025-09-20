import java.util.NoSuchElementException;

public class LinearQueue<T> {
    // ← FIELDS: Array to store elements + 2 pointers
    private T[] queue;
    private int front = 0;  // ← POINTS TO HEAD OF QUEUE (element to dequeue)
    private int rear = 0;   // ← POINTS TO TAIL OF QUEUE (position to enqueue)
    private int capacity;   // ← MAXIMUM SIZE OF QUEUE


    @SuppressWarnings("unchecked")
    public LinearQueue(int capacity) {
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];
    }


    // ← ENQUEUE: Add element to END of queue (FIFO: add to tail)
    public void enqueue(T item) {
        // TODO: Check if queue is full
        // HINT: if (rear == capacity) throw new IllegalStateException("Queue is full");
        if (rear == capacity) {
            throw new IllegalStateException("Queue is full");
        }

        // TODO: Add item at rear position
        queue[rear] = item; // Assign A by index 0
        // TODO: Move rear pointer forward
        rear = rear + 1;

    }


    // ← DEQUEUE: Remove and return element from HEAD of queue (FIFO: remove from front)
    public void dequeue() {
        // TODO: Check if queue is empty
        if (front == rear) {
            throw new NoSuchElementException("Empty Queue");
        }
        queue[front] = null; // front = 0
        front++;
    }


    // ← PEEK: View element at head of queue WITHOUT removing it
    public T peek() {
        // TODO: Check if queue is empty
        // HINT: if (front == rear) throw new NoSuchElementException("Queue is empty");
        if (front == rear) {
            throw new NoSuchElementException("Empty queue");
        }
        return queue[front];
    }


    // ← IS EMPTY: Check if queue has no elements
    public boolean isEmpty() {
        // TODO: Return true if queue is empty
        return front == rear;
    }


    // ← SIZE: Return current number of elements in queue
    public int size() {
        // TODO: Calculate number of elements = distance between rear and front
        // HINT: return rear - front;
        return rear - front;
    }


    // ← MAIN: Test your implementation
    public static void main(String[] args) {
        // TODO: Create queue with capacity = 5
        LinearQueue<String> queue = new LinearQueue<>(5);


        // TODO: Test enqueue 3 elements
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("Size: " + queue.size()); // Expected: 3
        System.out.println("Peek: " + queue.peek()); // Expected: A


        // TODO: Test exception cases
       /*
       try {
           queue.dequeue(); // Try to dequeue when still 2 elements left
       } catch (NoSuchElementException e) {
           System.out.println("✅ Correct: " + e.getMessage());
       }


       // Fill queue to test full exception
       queue.enqueue("E");
       queue.enqueue("F");
       queue.enqueue("G"); // This should throw IllegalStateException
       */
    }
}
