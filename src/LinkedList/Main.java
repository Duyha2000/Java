package LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.addLast(5);
        list.addLast(12);
        list.addLast(6);
        list.addLast(8);

        list.printList(); // 5 -> 12 -> 6 -> 8 -> null

        System.out.println("Size: " + list.size()); // 4
        System.out.println("Contains 12? " + list.contains(12)); // true
        System.out.println("First: " + list.getFirst()); // 5
        System.out.println("Last: " + list.getLast()); // 8

        list.removeFirst();
        list.printList(); // 12 -> 6 -> 8 -> null

        list.removeLast();
        list.printList(); // 12 -> 6 -> null
    }
}
