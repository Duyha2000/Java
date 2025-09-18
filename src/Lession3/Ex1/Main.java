package Lession3.Ex1;

public class Main {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>(5);

        // Push 6 elements (will trigger resize on the 6th push)
        System.out.println("Pushing elements:");
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("F");

        // Pop 3 elements
        System.out.println("\nPopping 3 elements:");
        System.out.println("Popped: " + stack.pop()); // F
        System.out.println("Popped: " + stack.pop()); // E
        System.out.println("Popped: " + stack.pop()); // D

        // Print top element and size
        System.out.println("\nTop: " + stack.peek()); // C
        System.out.println("Size: " + stack.size());  // 3
    }
}
