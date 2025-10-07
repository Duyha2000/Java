package Project3;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class GenericLinkedList<T> implements Iterable<T> {
    // Node class for doubly linked list
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

    // Constructor
    public GenericLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Gets the first element without removing it
    public T getFirst() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        return head.data;
    }

    // Gets the last element without removing it
    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        return tail.data;
    }

    // Addfirst - addLast
    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;  // list rỗng
        } else {
            newNode.next = head;    // bước 1
            head.previous = newNode;    // bước 3
            head = newNode;         // bước 4
        }
    }

    public void addLast(T data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;  // list rỗng
        } else {
            newNode.previous = tail;    // bước 1
            tail.next = newNode;    // bước 3
            tail = newNode;         // bước 4
        }
    }

    public void insert(T data, int index) {
        Node newNode = new Node(data);
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index);
        // TH1: chèn đầu
        if (index == 0) {
            addFirst(data);
            size++;
            return;
        }

        // TH2: chèn cuối
        if (index == size) {
            addLast(data);
            size++;
            return;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        newNode.previous = current.previous;
        newNode.next = current;
        current.previous.next = newNode;
        current.previous = newNode;
        size++;
    }


    // Checks if the list contains the specified element
    public boolean contains(T element) {
        for (Node current = head; current != null; current = current.next) {
            if (current.data == element || current.data.equals(element)) return true;
        }
        return false;
    }


    // Returns the element at the specified index
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }


    // Checks if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }


    // Removes the element at the specified index
    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        T data = current.data;
        removeNode(current);
        return data;
    }

    // Removes the first occurrence of the specified element
    public boolean remove(T element) {
        Node current = head;
        while (current != null) {
            if (Objects.equals(current.data, element)) {
                removeNode(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Removes and returns the first element
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        T data = head.data;
        removeNode(head);
        return data;
    }

    // Removes and returns the last element
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        T data = tail.data;
        removeNode(tail);
        return data;
    }

    // Gets the number of elements in the list
    public int size() {
        return size;
    }

    // Converts the list to an array
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    // Helper method to remove a node
    private void removeNode(Node node) {
        if (node == null) return;

        if (node == head && node == tail) {
            head = null;
            tail = null;
        } else if (node == head) {
            head = head.next;
            head.previous = null;
        } else if (node == tail) {
            tail = tail.previous;
            tail.next = null;
        } else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        size--;
    }

    // Returns a list iterator
    @Override
    public ListIterator<T> iterator() {
        return new GenericIterator();
    }

    // Inner class implementing ListIterator
    private class GenericIterator implements ListIterator<T> {
        private Node current; // Node to be returned by next()
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
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next element");
            }
            lastReturned = current;
            current = current.next;
            canRemove = true;
            return lastReturned.data;
        }

        @Override
        public boolean hasPrevious() {
            return current != null ? current.previous != null : head != null;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException("No previous element");
            }
            if (current == null) {
                current = tail;
            } else {
                current = current.previous;
            }
            lastReturned = current;
            canRemove = true;
            return current.data;
        }

        @Override
        public void remove() {
            if (!canRemove || lastReturned == null) {
                throw new IllegalStateException("Invalid remove operation");
            }
            removeNode(lastReturned);
            if (current != null && current.previous == lastReturned) {
                current = current.next; // Adjust current if we removed previous
            }
            lastReturned = null;
            canRemove = false;
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
}