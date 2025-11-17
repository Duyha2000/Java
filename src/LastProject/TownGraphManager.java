package LastProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Implementation of the Professor's TownGraphManagerInterface.
 * Internally uses adjacency map: Map<Town, Set<Road>>.
 * <p>
 * getPath uses Dijkstra to compute shortest path (by weight).
 * getRoad returns the name of a road directly connecting town1 and town2 (if any).
 */
public class TownGraphManager implements TownGraphManagerInterface {

    private final Map<Town, Set<Road>> adjacency;

    public TownGraphManager() {
        adjacency = new HashMap<>();
    }

    /* ---------- Helpers ---------- */

    // find Town object by exact name (case-sensitive)
    private Town findTownByName(String name) {
        if (name == null) return null;
        for (Town t : adjacency.keySet()) {
            if (t.getName().equals(name)) return t;
        }
        return null;
    }

    // get Road connecting a and b (if multiple, return the one with smallest weight)
    private Road findRoadBetween(Town a, Town b) {
        if (a == null || b == null) return null;
        for (Road r : adjacency.getOrDefault(a, Collections.emptySet())) {
            if ((r.getSource().equals(a) && r.getDestination().equals(b))
                    || (r.getSource().equals(b) && r.getDestination().equals(a))) {
                return r; // first found (sets are unordered). We'll select minimum-weight explicitly if needed.
            }
        }
        return null;
    }

    // returns a unique set of all Road objects
    private Set<Road> allRoadObjects() {
        Set<Road> out = new HashSet<>();
        for (Set<Road> rs : adjacency.values()) out.addAll(rs);
        return out;
    }

    /* ---------- Interface methods ---------- */

    @Override
    public boolean addRoad(String town1, String town2, int weight, String roadName) {
        if (town1 == null || town2 == null || roadName == null) return false;
        Town a = findTownByName(town1);
        Town b = findTownByName(town2);
        if (a == null) {
            a = new Town(town1);
            adjacency.putIfAbsent(a, new HashSet<>());
        }
        if (b == null) {
            b = new Town(town2);
            adjacency.putIfAbsent(b, new HashSet<>());
        }
        Road newRoad = new Road(a, b, weight, roadName);
        // avoid duplicate same-road (undirected equality)
        if (adjacency.get(a).contains(newRoad)) return false;
        adjacency.get(a).add(newRoad);
        adjacency.get(b).add(newRoad);
        return true;
    }

    @Override
    public String getRoad(String town1, String town2) {
        Town a = findTownByName(town1);
        Town b = findTownByName(town2);
        if (a == null || b == null) return null;
        // we may have multiple roads; choose the smallest weight one (sensible)
        Road best = null;
        for (Road r : adjacency.getOrDefault(a, Collections.emptySet())) {
            if ((r.getSource().equals(a) && r.getDestination().equals(b))
                    || (r.getSource().equals(b) && r.getDestination().equals(a))) {
                if (best == null || r.getWeight() < best.getWeight()) best = r;
            }
        }
        return (best == null) ? null : best.getName();
    }

    @Override
    public boolean addTown(String v) {
        if (v == null || v.trim().isEmpty()) return false;
        Town t = new Town(v.trim());
        if (adjacency.containsKey(t)) return false;
        adjacency.put(t, new HashSet<>());
        return true;
    }

    @Override
    public boolean containsTown(String v) {
        return findTownByName(v) != null;
    }

    @Override
    public boolean containsRoadConnection(String town1, String town2) {
        Town a = findTownByName(town1);
        Town b = findTownByName(town2);
        if (a == null || b == null) return false;
        for (Road r : adjacency.getOrDefault(a, Collections.emptySet())) {
            if ((r.getSource().equals(a) && r.getDestination().equals(b))
                    || (r.getSource().equals(b) && r.getDestination().equals(a))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<String> allRoads() {
        Set<String> names = new TreeSet<>();
        for (Road r : allRoadObjects()) names.add(r.getName());
        return new ArrayList<>(names);
    }

    @Override
    public boolean deleteRoadConnection(String town1, String town2, String road) {
        Town a = findTownByName(town1);
        Town b = findTownByName(town2);
        if (a == null || b == null || road == null) return false;
        Road found = null;
        for (Road r : adjacency.getOrDefault(a, Collections.emptySet())) {
            if (r.getName().equals(road)
                    && ((r.getSource().equals(a) && r.getDestination().equals(b))
                    || (r.getSource().equals(b) && r.getDestination().equals(a)))) {
                found = r;
                break;
            }
        }
        if (found == null) return false;
        adjacency.get(a).remove(found);
        adjacency.get(b).remove(found);
        return true;
    }

    @Override
    public boolean deleteTown(String v) {
        Town t = findTownByName(v);
        if (t == null) return false;
        // remove incident roads from neighbors
        for (Road r : new HashSet<>(adjacency.get(t))) {
            Town other = r.getSource().equals(t) ? r.getDestination() : r.getSource();
            adjacency.get(other).remove(r);
        }
        adjacency.remove(t);
        return true;
    }

    @Override
    public ArrayList<String> allTowns() {
        TreeSet<String> sorted = new TreeSet<>();
        for (Town t : adjacency.keySet()) sorted.add(t.getName());
        return new ArrayList<>(sorted);
    }

    @Override
    public ArrayList<String> getPath(String town1, String town2) {
        Town source = findTownByName(town1);
        Town dest = findTownByName(town2);
        if (source == null || dest == null) return null;

        // Dijkstra: distances + previousTown
        Map<Town, Integer> dist = new HashMap<>();
        Map<Town, Town> prev = new HashMap<>();
        for (Town t : adjacency.keySet()) {
            dist.put(t, Integer.MAX_VALUE);
            prev.put(t, null);
        }
        dist.put(source, 0);

        // PriorityQueue ordering by current distance
        PriorityQueue<Town> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));
        pq.add(source);

        while (!pq.isEmpty()) {
            Town u = pq.poll();
            int dU = dist.get(u);
            if (dU == Integer.MAX_VALUE) break;
            if (u.equals(dest)) break; // we can stop early

            for (Road r : adjacency.getOrDefault(u, Collections.emptySet())) {
                Town v = r.getSource().equals(u) ? r.getDestination() : r.getSource();
                int alt = dU + r.getWeight();
                if (alt < dist.get(v)) {
                    dist.put(v, alt);
                    prev.put(v, u);
                    // update PQ position: remove then add
                    pq.remove(v);
                    pq.add(v);
                }
            }
        }

        if (dist.get(dest) == Integer.MAX_VALUE) {
            return null; // no path
        }

        // reconstruct town path
        LinkedList<Town> townPath = new LinkedList<>();
        for (Town at = dest; at != null; at = prev.get(at)) townPath.addFirst(at);

        // convert to list of road names in order
        ArrayList<String> roadNames = new ArrayList<>();
        for (int i = 0; i < townPath.size() - 1; i++) {
            Town a = townPath.get(i);
            Town b = townPath.get(i + 1);
            // find the connecting road with minimal weight (in case multiple)
            Road chosen = null;
            for (Road r : adjacency.getOrDefault(a, Collections.emptySet())) {
                if ((r.getSource().equals(a) && r.getDestination().equals(b))
                        || (r.getSource().equals(b) && r.getDestination().equals(a))) {
                    if (chosen == null || r.getWeight() < chosen.getWeight()) chosen = r;
                }
            }
            if (chosen != null) roadNames.add(chosen.getName());
            else roadNames.add("UNKNOWN"); // should not happen
        }

        return roadNames;
    }

    @Override
    public void populateGraph(String filename) throws IOException {
        // Expect: road-name,miles;town1;town2
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split(";");
                if (parts.length < 3) continue;
                String roadAndMiles = parts[0].trim();
                String town1 = parts[1].trim();
                String town2 = parts[2].trim();
                String[] rm = roadAndMiles.split(",", 2);
                if (rm.length < 2) continue;
                String roadName = rm[0].trim();
                int miles;
                try {
                    miles = Integer.parseInt(rm[1].trim());
                } catch (NumberFormatException e) {
                    continue;
                }
                addTown(town1);
                addTown(town2);
                addRoad(town1, town2, miles, roadName);
            }
        }
    }
}
