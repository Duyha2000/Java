package LastProject;

import java.util.*;

public class TownGraphManagerDraft implements TownGraphManagerInterface {

    private final Map<Town, Set<Road>> adjacency;

    public TownGraphManagerDraft() {
        adjacency = new HashMap<>();
    }

    /* ---- Helper: tìm Town theo tên ---- */
    private Town findTownByName(String name) {
        if (name == null) return null;
        for (Town t : adjacency.keySet()) {
            if (t.getName().equals(name)) return t;
        }
        return null;
    }

    /* ---- Helper: tập hợp tất cả Road ---- */
    private Set<Road> allRoadObjects() {
        Set<Road> out = new HashSet<>();
        for (Set<Road> rs : adjacency.values()) out.addAll(rs);
        return out;
    }

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
        TreeSet<String> sorted = new TreeSet<>();
        for (Road r : allRoadObjects()) sorted.add(r.getName());
        return new ArrayList<>(sorted);
    }

    /* ===================================================
     *                 ADD ROAD
     *  Lấy được Town A và Town B từ graph.
        Kiểm tra xem giữa A và B đã có Road tên roadName chưa.
        Nếu có rồi → return false.
        Nếu chưa → tạo Road mới.
        Thêm Road này vào adjacency list của A và B.
     * =================================================== */
    @Override
    public boolean addRoad(String town1, String town2, int weight, String roadName) {
        Town t1 = findTownByName(town1);
        Town t2 = findTownByName(town2);
        if (t1 == null || t2 == null || roadName == null) return false;
        // kiểm tra đã có road giữa 2 town chưa
        // Kiểm tra road đã tồn tại giữa hai town chưa
        for (Road r : adjacency.get(t1)) {
            if (r.contains(t1) && r.contains(t2)) return false; // đã có road nối giữa 2 town
        }
        // Tạo road mới
        Road newRoad = new Road(t1, t2, weight, roadName);
        // Thêm vào danh sách của cả 2 town
        adjacency.get(t1).add(newRoad);
        adjacency.get(t2).add(newRoad);
        return true;
    }

    /* ===================================================
     *                     GET ROAD
     * =================================================== */
    @Override
    public String getRoad(String town1, String town2) {
        Town t1 = findTownByName(town1);
        Town t2 = findTownByName(town2);
        if (t1 == null || t2 == null) return null;
        for (Road r : adjacency.get(t1)) {
            if (r.contains(t1) && r.contains(t2)) return r.getName(); // Nếu road r chạm cả 2 town → đây là road cần tìm
        }
        return null;
    }

    /* ===================================================
     *        CHECK ROAD CONNECTION (true/false)
     * =================================================== */
    @Override
    public boolean containsRoadConnection(String town1, String town2) {
        return getRoad(town1, town2) != null;
    }

    /* ===================================================
     *                   DELETE ROAD
     * =================================================== */
    @Override
    public boolean deleteRoadConnection(String town1, String town2, String roadName) {
        Town t1 = findTownByName(town1);
        Town t2 = findTownByName(town2);

        if (t1 == null || t2 == null) return false;
        Road target = null;
        // duyệt các road nối với t1 để tìm road nối cả hai town và có đúng tên
        for (Road r : adjacency.get(t1)) {
            if (r.contains(t1) && r.contains(t2) && r.getName().equals(roadName)) {
                target = r;
                break;
            }
        }
        if (target == null) return false; // không tìm thấy road phù hợp
        // xóa road khỏi cả hai tập
        adjacency.get(t1).remove(target);
        adjacency.get(t2).remove(target);

        return true;
    }

    /* ===================================================
     *                   DELETE TOWN
     * =================================================== */
    @Override
    public boolean deleteTown(String townName) {
        Town t = findTownByName(townName);
        if (t == null) return false;
        // Lấy tất cả road nối với town t
        Set<Road> roadsOfT = new HashSet<>(adjacency.get(t));
        // Duyệt từng road và xóa khỏi town còn lại
        for (Road r : roadsOfT) {
            Town source = r.getSource();
            Town destination = r.getDestination();
            Town other;
            // Xác định town còn lại trong road này
            if (source.equals(t)) other = destination;
            else other = source;
            // Xóa road khỏi set của town còn lại
            Set<Road> otherList = adjacency.get(other);
            if (otherList != null) otherList.remove(r);
        }

        // Cuối cùng, xóa luôn t khỏi map
        adjacency.remove(t);
        return true;
    }
}
