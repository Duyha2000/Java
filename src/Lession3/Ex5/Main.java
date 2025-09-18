package Lession3.Ex5;

import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>(10);

        System.out.println("=== Stack Test ===");

        // Test 1: Initial state
        System.out.println("Initial state:");
        System.out.println("Size: " + stack.size());
        System.out.println("IsEmpty: " + stack.isEmpty());
        System.out.println();

        // Test 2: Push 5 elements
        System.out.println("Pushing 5 elements: A, B, C, D, E");
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");

        System.out.println("After pushing 5 elements:");
        System.out.println("Size: " + stack.size());
        System.out.println("IsEmpty: " + stack.isEmpty());
        System.out.println("Top: " + stack.peek());
        System.out.println();

        // Test 3: Pop 3 elements
        System.out.println("Popping 3 elements:");
        for (int i = 0; i < 3; i++) {
            try {
                String item = stack.pop();
                System.out.println("Popped: " + item);
            } catch (EmptyStackException e) {
                System.out.println("Stack is empty - cannot pop");
            }
        }

        System.out.println();

        // Test 4: Check remaining state
        System.out.println("After popping 3 elements:");
        System.out.println("Top: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("IsEmpty: " + stack.isEmpty());
        System.out.println();

        // Test 5: Test overflow
        System.out.println("Testing overflow with 5 more pushes:");
        try {
            stack.push("F");
            stack.push("G");
            stack.push("H");
            stack.push("I");
            stack.push("J"); // This should cause overflow
        } catch (RuntimeException e) {
            System.out.println("Caught overflow: " + e.getMessage());
        }

        System.out.println("Final size: " + stack.size());
        System.out.println("Final top: " + stack.peek());
    }
}