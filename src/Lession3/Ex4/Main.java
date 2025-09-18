package Lession3.Ex4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Alice", 25),
                new Person("Bob", 20),
                new Person("Charlie", 25),
                new Person("David", 30)
        };

        // Create comparator instance
        PersonComparator comparator = new PersonComparator();

        // Sort people using the comparator
        Arrays.sort(people, comparator);

        // Print the sorted results
        System.out.println("Sorted people:");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}