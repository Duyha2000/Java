package LinkedList.Doubly;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Iterable<T> {
    private class Node {
        T data;
        Node next;
        Node previous;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public T getFirst() {
        return head.data;
    }

    public T getLast() {
        return tail.data;
    }

    // get(index) - contain(T element)
    public T getIndex(int index) {
        if (index < 0 || index > size) throw new IllegalStateException("Index cannot be negative or empty");

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public boolean contains(T element) {
        for (Node current = head; current != null; current = current.next) {
            if (current.data == element || current.data.equals(element))
                return true;
        }
        return false;
    }


    // Addfirst - addLast
    public void addFirst(T data) {
        Node newNode = new Node(data);
        // TH1: empty linkedlist
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            // TH2: >= 2 elements in linkedlist
            newNode.next = head.next; // B1
            head.previous = newNode; // B2
            head = newNode; // B3
        }
        size++;
    }

    public void addLast(T data) {
        Node newNode = new Node(data);
        // TH1: empty linkedlist
        if (isEmpty()) {
            head = newNode;
        } else {
            // TH2: >= 2 elements in linkedlist
            newNode.previous = tail;
            tail.next = newNode;
        }
        tail = newNode;
        size--;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public void deleteFirst() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        if (head == tail) { // Only one element
            head = null;
            tail = null;
        } else { // More than one element
            head = head.next;
            head.previous = null;
        }
        size--;
    }

    public void deleteLast() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        if (head == tail) { // Only one element
            head = null;
            tail = null;
        } else { // More than one element
            tail = tail.previous;
            tail.next = null;
        }
        size--;
    }

    public void deleteAtIndex(int index) {
        if (isEmpty() || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) deleteFirst();
        if (index == size - 1) deleteLast();

        // Traverse to the node at index
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;

        current.previous.next = current.next;
        current.next.previous = current.previous;
        size--;
    }

    @Override
    public ListIterator<T> iterator() {
        return new GenericIterator();
    }

    public class GenericIterator implements ListIterator<T> {
        private Node current;
        private Node lastReturned; // Last node returned by next() or previous()
        private boolean canRemove; // Tracks if remove() is valid

        public GenericIterator() {
            current = head;
            lastReturned = null;
            canRemove = false;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public boolean hasPrevious() {
            // 1️⃣ Nếu iterator đang ở giữa list (current != null) -> Có previous nếu node hiện tại có liên kết previous
            if (current != null)
                return current.previous != null;
                // 2️⃣ Nếu iterator đang ở sau cùng (current == null) -> Có previous nếu list không rỗng (vì có thể lùi về tail)
            else
                return head != null;
        }

        @Override
        public T next() {
            return null;
        }


        @Override
        public T previous() {
            return null;
        }

        @Override
        public void remove() {

        }


        // Unsupported operations
        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }


        @Override
        public void set(T e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(T e) {
            throw new UnsupportedOperationException();
        }
    }

    ;

}


