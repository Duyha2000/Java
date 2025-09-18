package Lession3.Ex4;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        // Primary criterion: Sort by age (youngest first)
        int ageCompare = Integer.compare(p1.getAge(), p2.getAge());
        if (ageCompare != 0) {
            return ageCompare;
        }

        // Secondary criterion: If ages are equal, sort by name (alphabetically)
        return p1.getName().compareTo(p2.getName());
    }
}