package LastProject;

import java.util.Objects;

public class Town implements Comparable<Town> {
    private String name;

    public Town(String name) {
        if (name == null) throw new IllegalArgumentException("Town name cannot be null");
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    // compareTo for alphabetical ordering
    @Override
    public int compareTo(Town o) {
        return this.name.compareTo(o.name);
    }

    // Two towns are equal if their names are equal (case-sensitive)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Town other)) return false;
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
