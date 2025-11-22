package LastProject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphDraft implements GraphInterface<Town, Road> {

    private Map<Town, Set<Road>> adjacency = new HashMap<>();

    @Override
    public Road getEdge(Town source, Town destination) {
        if (source == null || destination == null) return null;
        Set<Road> roads = adjacency.get(source);
        if (roads == null) return null;
        for (Road r : roads) {
            if (r.contains(source) && r.contains(destination)) return r;
        }
        return null;
    }

    @Override
    public Road addEdge(Town source, Town destination, int weight, String description) {
        if (source == null || destination == null) return null;

        adjacency.putIfAbsent(source, new HashSet<>());
        adjacency.putIfAbsent(destination, new HashSet<>());

        // nếu đã có road giữa 2 town, return null
        if (getEdge(source, destination) != null) return null;

        Road newRoad = new Road(source, destination, weight, description);
        adjacency.get(source).add(newRoad);
        adjacency.get(destination).add(newRoad);

        return newRoad;
    }

    @Override
    public boolean addVertex(Town town) {
        if (town == null) return false;
        if (adjacency.containsKey(town)) return false;

        adjacency.put(town, new HashSet<>());
        return true;
    }

    @Override
    public boolean containsEdge(Town source, Town destination) {
        return getEdge(source, destination) != null;
    }

    @Override
    public boolean containsVertex(Town town) {
        return adjacency.containsKey(town);
    }

    @Override
    public Set<Road> edgeSet() {
        Set<Road> all = new HashSet<>();
        for (Set<Road> rs : adjacency.values()) {
            all.addAll(rs);
        }
        return all;
    }

    @Override
    public Set<Road> edgesOf(Town vertex) {
        return adjacency.getOrDefault(vertex, Set.of());
    }

    @Override
    public Road removeEdge(Town source, Town destination, int weight, String description) {
        Road target = getEdge(source, destination);
        if (target == null) return null;

        adjacency.get(source).remove(target);
        adjacency.get(destination).remove(target);
        return target;
    }

    @Override
    public boolean removeVertex(Town town) {
        if (!adjacency.containsKey(town)) return false;

        Set<Road> roads = new HashSet<>(adjacency.get(town));
        for (Road r : roads) {
            Town other = r.getSource().equals(town)
                    ? r.getDestination()
                    : r.getSource();
            adjacency.get(other).remove(r);
        }

        adjacency.remove(town);
        return true;
    }

    @Override
    public Set<Town> vertexSet() {
        return adjacency.keySet();
    }
}
