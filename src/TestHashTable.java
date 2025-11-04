public class TestHashTable {
    public static void main(String[] args) {
        MyHashTable<String, Integer> table = new MyHashTable<>();
        table.put("Banh mi", 20000);
        table.put("com", 10000);
        System.out.println(table.getValue("Banh mi"));

        table.put("com", 15000);
        System.out.println(table.getValue("com"));
        table.remove("Banh mi");
        System.out.println(table.getValue("Banh mi"));


        //   HashMap<String, Integer> menus = new HashMap<>();
        //   menus.put("Banh mi", 20000);

    }
}












/*
MyHashTable<String, Integer> table = new MyHashTable<>();

table.put("Alice", 10);
table.put("Bob", 20);
//        System.out.println(table.getValue("Bob"));

table.put("Charlie", 30);
table.put("Alice", 50); // update value

System.out.println(table.getValue("Alice")); // 50
System.out.println(table.getValue("Bob"));   // 20
System.out.println(table.containsKey("Charlie")); // true

table.remove("Bob");
System.out.println(table.getValue("Bob"));   // null
System.out.println(table.size());       // 2
 */