import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Map {
    public static void main(String[] args) {
        /* TODO: HashMap: put, get, containsKey, remove, duyệt keySet, duyệt entrySet
        key - value -> pair
         */
//        HashMap<String, Integer> menus = new HashMap<>();
//        // add, update: put()
//        // Pho - 30k - bun dau - 50k - bun cha - 60k
//        menus.put("Pho", 30000);
//        menus.put("bun dau", 50000);
//        menus.put("bun cha", 60000);
//        // Lay gia tri trong Hashmap dua vao key:
//        System.out.println(menus.get("Pho"));
//        // Bat pho nay 40k -> update gia tien bat pho: put
//        menus.put("Pho", 40000);
//        System.out.println(menus.get("Pho"));
//        // containKeys: Kiem tra xem co mon bun ca hay ko
//
//        if (menus.containsKey("bun ca")) {
//            System.out.println("Co mon nay!!!");
//        } else System.out.println("ko co");
//
//        // remove(xoa key - value): xoa di bun cha
//        menus.remove("bun cha", 60000);
        // In cac phan tu trong HashMap:
        // In ra value dua vao key: keyset () -> lay ra cac key trong HashMap
//        for (String key : menus.keySet()) {
//            System.out.println(key + " -> " + menus.get(key));
//        }
        // C2: Entry (cap key - value)
//        for (HashMap.Entry<String, Integer> entry : menus.entrySet()) {
//            System.out.println(entry.getKey() + "-> " + entry.getValue());
//        }
        /*
        TODO: Bài 1 — Map cơ bản
        Tạo HashMap<String, Integer> lưu điểm của 3 sinh viên:
        Add 3 sinh viên
        In ra tất cả
        Update điểm của 1 người
        Kiểm tra 1 người có trong Map không
        Xóa 1 người
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 100);
        map.put("b", 90);
        map.put("c", 80);
        map.put("a", 70);
        System.out.println(map.get("a"));
        if (map.containsKey("b")) {
        System.out.println("yes");
        } else System.out.println("no");
        map.remove("b", 90);
        for (String key : map.keySet()) {
        System.out.println(key + ": " + map.get(key));
        }
        ⭐ Bài 2 — Frequency Counter (Đếm số lần xuất hiện)
        Cho mảng [] -> them cac phan tu vao hashMap -> ["Chicago", "Detroit", "Chicago", "Boston", "Boston", "Chicago"]
        Hãy dùng HashMap<String, Integer> để:
        Đếm số lần mỗi thành phố xuất hiện
        In ra kết quả theo dạng:
        Chicago -> 3
        Detroit -> 1
        Boston  -> 2
        -> Neu phan tu nay chua co trong hashmap -> tao 1 key moi voi value = 1
        Neu phan tu nay da co trong hashmap -> tang value len 1
         */
        HashMap<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
//        for (int i = 0; i <= 5; i++) {
//            String key = scanner.nextLine();
//            if (map.containsKey(key)) { // da ton tai
//                map.put(key, map.get(key) + 1);
//            } else
//                map.put(key, 1);
//        }

        while (true) {
            String key = scanner.nextLine();
            if (map.containsKey(key)) { // da ton tai
                map.put(key, map.get(key) + 1);
            } else
                map.put(key, 1);
            if (Objects.equals(key, "stop")) break;
        }

        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}
