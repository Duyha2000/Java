import java.util.EmptyStackException;

public class Stack<T> {
    private T[] stack;
    private int top;
    private int capacity;

    // https://docs.google.com/document/d/1V2uhLBNN_ITpXO2eL9MTpHiFdcwVnWSNZ4J6JV1zAvs/edit?tab=t.0#heading=h.77i6raan3k2h
    // https://docs.google.com/spreadsheets/d/1AHleYM1JweYpHPo8dx8kWsNQCkXjRfn-yRd7HVzWBXo/edit?gid=0#gid=0
    // Constructor to initialize the stack with the given initial capacity
    @SuppressWarnings("unchecked")
    public Stack(int initialCapacity) {
        this.capacity = initialCapacity; // Set the initial capacity
        this.stack = (T[]) new Object[initialCapacity]; // Create the stack array
        this.top = -1; //  Initialize the top index as -1 (indicating an empty stack)
    }


    // TODO: Method to push an item onto the stack
    public void push(T item) {
        // FIXME: 1. Check if the stack is full, and resize if necessary. Double the capacity if full
        if (top == capacity - 1) {
            resize(capacity * 2);
        }
        // FIXME: 2. Add the item to the stack and increment the top index:
        // arr[-1]
        stack[top++] = item;

    }


    // TODO: Method to pop an item from the stack
    public T pop() {
        // FIXME: Implement pop, throw exception if empty
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        // FIXME: the item to return (Lấy ra phần tử -> gắn null)
        // arr 3 4 5 6 [7]
        // FIXME: Remove the item and decrement the top index
        stack[top--] = null;

        return stack[top];
    }


    // TODO: Method to peek at the top item without removing it
    public T peek() {
        // FIXME: Throw an exception if the stack is empty
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // arr = {1,2,3,4,5}
        // arr[4] -> value | top : index =
        return stack[top]; // FIXME: Return the top item without removing it
    }


    // TODO: Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1); // FIXME: Return true if the top index is -1 (stack is empty)
    }


    // TODO: Method to return the current size of the stack
    public int size() {
        return (top + 1); // FIXME: Return the number of elements in the stack

    }


    // TODO: Helper method to resize the stack when full
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        // FIXME: Update the capacity to the new size
        T[] stack1 = (T[]) new Object[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            stack1[i] = stack[i];
        }
        stack = stack1;
    }

    public void display() {
        System.out.println("Stack: ");
        for (T sta : stack) {
            System.out.println(sta + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>(5);
//        s.pop(4);
//        System.out.println("new arr: " + s);
//        s.push(4);
//        s.push(3);
//        s.push(6);


        try {
            s.pop();
        } catch (EmptyStackException e) {
            System.err.println(e.getMessage());
        }

//        s.display();
        // 3 4 5 6 7
        // arrList.add(4);
//        int[] arr = {3, 4, 5, 6, 7};
//        // add 8
//        int[] arr1 = new int[arr.length + 1]; // [3 4 5 6 7 ...]
//
//        System.arraycopy(arr, 0, arr1, 0, arr.length);
//
//        arr1[arr.length] = 5;
//        // arr.add(8);
//        arr = arr1;
//
//        for (int ele : arr) {
//            System.out.print(ele + " ");
//        }
    }

}