package LastProject;

import java.util.ArrayList;

public interface TownGraphManagerInterface {
    // Kiểm tra xem trong graph có tồn tại town tên là v hay không.
    public boolean containsTown(String v);

    /*
    👉 Nó dùng để thêm một Town mới vào đồ thị, nếu Town đó chưa tồn tại.
    containsKey(t) kiểm tra xem Town đó đã tồn tại trong graph chưa
    Nếu đã có rồi → không thêm lần 2, return false.
    Thêm Town mới vào graph
    Gán cho nó một Set rỗng chứa các Road (vì Town mới chưa có đường nối nào).
     */
    public boolean addTown(String v);

    /*
    👉 Nó trả về danh sách TÊN (String) của tất cả các Town trong đồ thị,
     được sắp xếp theo thứ tự alphabet -> lưu trữ trong 1 tree set vì nó tự
     loại bỏ các tên trùng nhau -> cuối cùng convert về array list
     */
    public ArrayList<String> allTowns();

    /*
    👉 Nó trả về danh sách TÊN (String) của tất cả các Road trong đồ thị,
    được sắp xếp alphabet, và loại bỏ trùng lặp.
     */
    public ArrayList<String> allRoads();

    /* ===================================================
     *                 ADD ROAD (truyền thống)
     * =================================================== */
    boolean addRoad(String town1, String town2, int weight, String roadName);

    /* ===================================================
     *                     GET ROAD
     * =================================================== */
    String getRoad(String town1, String town2);

    /* ===================================================
     *        CHECK ROAD CONNECTION (true/false)
     * =================================================== */
    boolean containsRoadConnection(String town1, String town2);

    /* ===================================================
     *                   DELETE ROAD
     * =================================================== */
    boolean deleteRoadConnection(String town1, String town2, String roadName);

    /* ===================================================
     *                   DELETE TOWN
     * =================================================== */
    boolean deleteTown(String town);
}
