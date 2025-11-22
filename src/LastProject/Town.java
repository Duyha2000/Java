package LastProject;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Town implements Comparable<Town> {
    private String name;
    private Set<Town> adjTowns = new HashSet<>();
    private int wt;
    private Town backPath;

    // Constructor
    public Town(String name) {
        if (name == null)
            throw new IllegalArgumentException("Town name cannot be null");
        this.name = name.trim();
    }

    // Copy constructor
    public Town(Town templateTown) {
        this.name = templateTown.name;
        // Không copy adjTowns, wt, backPath vì mỗi đồ thị có context riêng
    }

    public String getName() {
        return name;
    }

    // Compare alphabetical
    @Override
    public int compareTo(Town o) {
        return this.name.compareTo(o.name);
    }

    // Add adjacency (undirected graph, you may control from outside)
    public void addAdjTown(Town adjTown) {
        if (adjTown == null) return;
        adjTowns.add(adjTown);
    }

    public Set<Town> getAdjTowns() {
        return adjTowns;
    }

    // Weight (used in Dijkstra)
    public int getWt() {
        return wt;
    }

    public void setWt(int wt) {
        this.wt = wt;
    }

    // Back pointer for path reconstruction
    public Town getBackPath() {
        return backPath;
    }

    public void setBackPath(Town backPath) {
        this.backPath = backPath;
    }

    // Optional: calculate min weight to source (if needed)
    // Usually this is the 'wt' field after Dijkstra updates
    public int getMinWtToSource(Town sourceVertex) {
        return wt;
    }

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
