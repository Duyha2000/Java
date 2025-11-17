package LastProject;

import java.util.Objects;

public class Road implements Comparable<Road> {
    private Town source;
    private Town destination;
    private int weight;
    private String name;

    // Constructor with explicit weight
    public Road(Town source, Town destination, int degrees, String name) {
        if (source == null || destination == null || name == null)
            throw new IllegalArgumentException("Arguments cannot be null");
        this.source = source;
        this.destination = destination;
        this.weight = degrees;
        this.name = name;
    }

    // Constructor with default weight = 1
    public Road(Town source, Town destination, String name) {
        this(source, destination, 1, name);
    }

    // Returns true if this road connects to the given town
    public boolean contains(Town town) {
        if (town == null) return false;
        return source.equals(town) || destination.equals(town);
    }

    public Town getSource() {
        return source;
    }

    public Town getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    // Compare by weight, then by name (lexicographically)
    @Override
    public int compareTo(Road o) {
        if (o == null) throw new NullPointerException("Comparing to null Road");
        int w = Integer.compare(this.weight, o.weight);
        if (w != 0) return w;
        return this.name.compareTo(o.name);
    }

    // Undirected equality: A-B equals B-A if name and weight match
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Road)) return false;
        Road other = (Road) obj;

        boolean sameDirection = this.source.equals(other.source) && this.destination.equals(other.destination);
        boolean reverseDirection = this.source.equals(other.destination) && this.destination.equals(other.source);

        return (sameDirection || reverseDirection)
                && this.weight == other.weight
                && this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        // make symmetric for undirected edge by using commutative combination
        int endSum = source.hashCode() + destination.hashCode();
        return Objects.hash(endSum, weight, name);
    }

    @Override
    public String toString() {
        return String.format("%s (%d mi) between %s and %s", name, weight, source, destination);
    }
}

