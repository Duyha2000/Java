package Project2;

import java.util.NoSuchElementException;

public class LinearQueue<T> {
    private T[] queue;
    private int front = 0;  // ← CHỈ VÀO ĐẦU HÀNG
    private int rear = 0;   // ← CHỈ VÀO CUỐI HÀNG (vị trí trống)
    private int capacity;

    @SuppressWarnings("unchecked")
    public LinearQueue(int capacity) {
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];
    }

    // THÊM VÀO CUỐI HÀNG
    public void enqueue(T item) {
        // Kiểm tra đầy (rear đã đến cuối array)
        if (rear == capacity) {
            throw new IllegalStateException("Queue is full");
        }

        // THÊM VÀO VỊ TRÍ REAR
        queue[rear] = item;
        rear++;  // ← Rear di chuyển sang phải
        System.out.println("Enqueued: " + item + " (rear=" + (rear - 1) + ")");
    }

    // LẤY TỪ ĐẦU HÀNG
    public T dequeue() {
        // Kiểm tra rỗng (front đã bắt kịp rear)
        if (front == rear) {
            throw new NoSuchElementException("Queue is empty");
        }

        // LẤY TỪ VỊ TRÍ FRONT
        T item = queue[front];
        queue[front] = null;  // Clear reference
        front++;  // ← Front di chuyển sang phải
        System.out.println("Dequeued: " + item + " (front=" + (front - 1) + ")");
        return item;
    }

    public T peek() {
        if (front == rear) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue[front];  // ← XEM ĐẦU HÀNG KHÔNG LẤY
    }

    public boolean isEmpty() {
        return front == rear;  // ← Rỗng khi front bắt kịp rear
    }

    public int size() {
        return rear - front;  // ← Kích thước = khoảng cách front-rear
    }

    public static void main(String[] args) {
        LinearQueue<String> queue = new LinearQueue<>(5);
//        System.out.println(queue.peek());
        ;
        queue.enqueue("A");
        System.out.println(queue.peek());

    }
}