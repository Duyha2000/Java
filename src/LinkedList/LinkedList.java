package LinkedList;

public class LinkedList<T> {
    private Node<T> head; // node đầu
    private int size;  // số lượng phần tử

    // Constructor
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Kiểm tra rỗng
    public boolean isEmpty() {
        return head == null;
    }

    // Độ dài
    public int size() {
        return size;
    }

    // Lấy phần tử đầu tiên
    public T getFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        return head.data;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data); // data = data, next = null
        newNode.next = head;                // Nối node mới với node đầu hiện tại
        head = newNode;                     // Cập nhật head trỏ đến node mới
        size++;
    }

    // In danh sách
    public void printList() {
        for (Node<T> current = head; current != null; current = current.next)
            System.out.print(current.data + " -> ");
    }

    // Xóa phần tử đầu tiên
    public void removeFirst() {
        if (!isEmpty()) {
            head = head.next;
            size--;
        }
    }

    // Find last element of linked list known as tail
    private Node<T> tail() {
        Node<T> tail;
        for (tail = head; tail != null; tail = tail.next) {
        }
        return tail;
    }

    // Lấy phần tử cuối cùng
    public T getLast() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        return tail().data;
    }

    // Thêm node vào cuối danh sách
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) head = newNode;
        else tail().next = newNode;
        size++;
    }


    // Lấy phần tử tại index
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of range");
        Node<T> current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }

    // Xóa phần tử cuối cùng
    public void removeLast() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        if (head.next == null) { // chỉ có 1 phần tử
            head = null;
            size--;
            return;
        }

        Node<T> current;
        for (current = head; current.next.next != null; current = current.next) {
        }
        current.next = null;
        size--;
    }
}
