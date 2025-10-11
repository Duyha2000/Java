package LinkedList.Doubly;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Iterable<T> {
    // https://docs.google.com/spreadsheets/d/1AHleYM1JweYpHPo8dx8kWsNQCkXjRfn-yRd7HVzWBXo/edit?gid=2002710219#gid=2002710219
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

    public void removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        if (head == tail) { // Only one element
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
            size--;
        }
    }

    public void removeLast() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        if (head == tail) { // Only one element
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
            size--;
        }
    }

    public void removeIndex(int index) {
        if (isEmpty() || index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index");
        if (index == 0) removeFirst();
        if (index == size - 1) removeLast();

        // B1: move pointer
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        // B2: Bnext -> D
        current.previous.next = current.next;
        current.next.previous = current.previous;
        size--;
    }

    public void insertIndex(int index, T data) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index);
        // TH1: chèn đầu
        if (index == 0) {
            addFirst(data);
            return;
        }

        // TH2: chèn cuối
        if (index == size) {
            addLast(data);
            return;
        }
        Node current = head;
        Node newNode = new Node(data);

        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        newNode.previous = current.previous;
        newNode.next = current;
        current.previous.next = newNode;
        current.previous = newNode;

        size++;
    }


    public Iterator<T> iterator() {
        return new ListIterator<>() {
            private Node current = head;
            private Node lastreturned = null;
            private boolean canRemove = false;
            // Kiểm tra xem có phần t kế tiếp hay không
            @Override
            public boolean hasNext() {
//                if(current == null) return false;
//                return true;
//                return current != null;
            }

            @Override
            public boolean hasPrevious() {
                // 1️⃣ Nếu iterator đang ở giữa list (current != null) -> Có previous nếu node hiện tại có liên kết previous
                if(current != null){
                    if(current.previous == null) return false; // first element (ko có previous)
                    else return true;
                }else{ // nam ben ngoai
                    if(head != null){
                        return true;
                    } else
                        return false;

                }
                //if (current != null)
                //  return current.previous != null;
                    // 2️⃣ Nếu iterator đang ở sau cùng (current == null) -> Có previous nếu list không rỗng (vì có thể lùi về tail)
//                else
//                    return head != null;
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
}


