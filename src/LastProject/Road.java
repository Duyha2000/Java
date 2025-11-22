package LastProject;

import java.util.Objects;

public class Road implements Comparable<Road> {
    private Town source;
    private Town destination;
    private int weight;
    private String name;

    // Constructor with explicit weight
    public Road(Town source, Town destination, int weight, String name) {
        if (source == null || destination == null || name == null)
            throw new IllegalArgumentException("Arguments cannot be null");
        this.source = source;
        this.destination = destination;
        this.weight = weight;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        if (weight != road.weight) return false;
        if (!Objects.equals(name, road.name)) return false;

        // either same orientation or swapped (undirected)
        boolean direct = Objects.equals(source, road.source) && Objects.equals(destination, road.destination);
        boolean swapped = Objects.equals(source, road.destination) && Objects.equals(destination, road.source);
        return direct || swapped;
    }

    @Override
    public int hashCode() {
        // commutative combination to be symmetric for undirected edge
        int s = source.hashCode();
        int d = destination.hashCode();
        int endsCombined = s + d; // commutative
        return Objects.hash(endsCombined, weight, name);
    }

    @Override
    public String toString() {
        return String.format("%s (%d) between %s and %s", name, weight, source, destination);
    }

    
}
