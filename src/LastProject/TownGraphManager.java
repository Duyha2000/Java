package LastProject;

import java.util.*;

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

    // TODO: trả về 1 set, bên trong chứa các đối tượng Road (object Road), mỗi Road là 1 object thật:
    // chứa source, destination, weight, name…
    private Set<Road> allRoadObjects() {
        Set<Road> out = new HashSet<>();
        for (Set<Road> rs : adjacency.values()) out.addAll(rs);
        return out;
    }

    /* ---------- Interface methods ---------- */

    @Override
    public boolean containsTown(String v) {
        return findTownByName(v) != null;
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
    public ArrayList<String> allTowns() {
        TreeSet<String> sorted = new TreeSet<>();
        for (Town t : adjacency.keySet()) sorted.add(t.getName());
        return new ArrayList<>(sorted);
    }

    @Override
    public ArrayList<String> allRoads() {
        Set<String> names = new TreeSet<>();
        for (Road r : allRoadObjects()) names.add(r.getName());
        return new ArrayList<>(names);
    }

    public boolean addRoad(String town1, String town2, int weight, String roadName) {
        /*
         * Returns the name of the road that both towns are connected through
         *
         * @param town1 name of town 1 (lastname, firstname)
         * @param town2 name of town 2 (lastname, firstname)
         * @return name of road if town 1 and town2 are in the same road, returns null if not
         */
        return false;
    }

    public String getRoad(String town1, String town2) {
        /*
         * Adds a town to the graph
         * @param v the town's name  (lastname, firstname)
         * @return true if the town was successfully added, false if not
         */
        return "";
    }

    public boolean containsRoadConnection(String town1, String town2) {
        /*
         * Creates an arraylist of all road titles in sorted order by road name
         * @return an arraylist of all road titles in sorted order by road name
         */
        return false;
    }

    public boolean deleteRoadConnection(String town1, String town2, String road) {
        /*
         * Deletes a town from the graph
         * @param v name of town (lastname, firstname)
         * @return true if the town was successfully deleted, false if not
         */
        return false;
    }

    public boolean deleteTown(String v) {
        /*
         * Creates an arraylist of all towns in alphabetical order (last name, first name)
         * @return an arraylist of all towns in alphabetical order (last name, first name)
         */
        return false;
    }

    // Dùng thuật toán Dijkstra.
    public ArrayList<String> getPath(String town1, String town2) {
        /*
         * Returns the shortest path from town 1 to town 2
         * @param town1 name of town 1 (lastname, firstname)
         * @param town2 name of town 2 (lastname, firstname)
         * @return an Arraylist of roads connecting the two towns together, null if the
         * towns have no path to connect them.
         */
        return new ArrayList<>();
    }
}
