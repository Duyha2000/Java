package Project3;

import java.util.ListIterator;
import java.util.NoSuchElementException;


public class GenericLinkedList<T> implements Iterable<T> {
    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public GenericLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean contains(T element) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public ListIterator<T> iterator() {
        return new GenericIterator();
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        T data = current.data;
        removeNode(current);
        return data;
    }

    public boolean remove(T element) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                removeNode(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T data = head.data;
        removeNode(head);
        return data;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T data = tail.data;
        removeNode(tail);
        return data;
    }

    private void removeNode(Node node) {
        if (node == head) {
            head = node.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (node == tail) {
            tail = node.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    public void add(T element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    private class GenericIterator implements ListIterator<T> {
        private Node current;
        private Node lastReturned;
        private boolean nextCalled;
        private boolean previousCalled;

        public GenericIterator() {
            current = head;
            lastReturned = null;
            nextCalled = false;
            previousCalled = false;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = current;
            current = current.next;
            nextCalled = true;
            previousCalled = false;
            return lastReturned.data;
        }

        public boolean hasPrevious() {
            return (current == null && tail != null) || (current != null && current.prev != null);
        }

        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (current == null) {
                current = tail;
            } else {
                current = current.prev;
            }
            lastReturned = current;
            previousCalled = true;
            nextCalled = false;
            return lastReturned.data;
        }

        public void remove() {
            if (lastReturned == null || (!nextCalled && !previousCalled)) {
                throw new IllegalStateException();
            }
            removeNode(lastReturned);
            if (previousCalled) {
                current = lastReturned.next;
            }
            lastReturned = null;
            nextCalled = false;
            previousCalled = false;
        }

        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        public void set(T e) {
            throw new UnsupportedOperationException();
        }

        public void add(T e) {
            throw new UnsupportedOperationException();
        }
    }
}