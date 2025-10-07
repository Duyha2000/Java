package LinkedList.Singly;

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

    public void addFirst(T data) {
        Node<T> newData = new Node<>(data);
        newData.next = head;
        head = newData;
        size++;
    }

    public T getFirst() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        return head.data;
    }

    public void removeFirst() {
        if (!isEmpty()) {
            head = head.next; // move pointer next
            size--;
        }
    }

    public void printList() {
        for (Node<T> current = head; current != null; current = current.next) {
            System.out.print(current.data + " ");
        }
    }

    // Find last element of linked list known as tail
    private Node<T> tail() {
        Node<T> current;
        for (current = head; current != null; current = current.next) {
        }
        return current;
    }

    // for -> move pointer to the last element
    public T getLast() {
        return tail().data;
    }

    // Add element to the last linkedlist
    public void addLast(T data) {
        Node<T> newData = new Node<>(data);
        if (isEmpty()) {
            head = newData;
        } else {
            tail().next = newData;
        }
        size++;
    }

    // Xóa phần tử cuối cùng
    public void removeLast() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        // 1 element
        if (head.next == null) {
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

    // contains(T element)
    public boolean contains(T element) {
        for (Node<T> current = head; current != null; current = current.next) {
            if (current.data == element || current.data.equals(element)) return true;
        }
        return false;
    }

    // get(index)
    public T get(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index cannot be negative");
        Node<T> current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }

    // insert(index)
    /*
    Index:   0     1     2
    Before: [A] → [B] → [C]
    After:  [A] → [X] → [B] → [C]
     */
    public void insert(int index, T data) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index cannot be negative");
        Node<T> current = head;
        Node<T> newNode = new Node<>(data);
        for (int i = 0; i < index - 1; i++) current = current.next;
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
}
