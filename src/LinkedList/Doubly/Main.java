package LinkedList.Doubly;

import LinkedList.Singly.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add(5);
//        for (int num : list2) {
//            System.out.println(num);
//        }
//
        list.addLast(4);
        list.addFirst(5);
        list.addFirst(10);

//        Iterator<Integer> it = arr.iterator();
//        while (it.hasNext()) {
//            int num = it.next();
//            System.out.println(num);
//        }

        for (int num : list) {
            System.out.println(num);
        }
    }
}
