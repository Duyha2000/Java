import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class Set {
    // Set: 1 array, chi luu tru phan tu khong trung lap
    // {1,1,2,2,3,4,5,6} =>  {1,2,3,4,5,6}
    public static void main(String[] args) {
//        HashSet<String> set = new HashSet<>();
//        // Add: Hung, Cuong, Nguyen, Hung
//        set.add("hung");
//        set.add("cuong");
//        set.add("nguyen");
//        set.add("hung");
//        // remove: xoa nguyem
//        set.remove("nguyen");
//        // contains: kiem tra cuonc co trong hashSet hay khong:
//
//        if (set.contains("cuong")) {
//            System.out.println("Found it");
//        } else
//            System.out.println("false");
//        for (String ele : set) {
//            System.out.println(ele);
//        }
/*
        ⭐ TODO: — Loại bỏ phần tử trùng trong danh sách
        Cho một ArrayList<String> chứa tên các thành phố, trong đó có nhiều tên trùng:
        ["Chicago", "Detroit", "Chicago", "Baltimore", "Detroit"]
        Hãy dùng HashSet để:
        +loại bỏ trùng
        +in ra tập các thành phố duy nhất
        +in ra kích thước Set
         HashSet<String> arrayList = new HashSet<>();
        arrayList.add("Chicago");
        arrayList.add("detroit");
        arrayList.add("Chicago");
        arrayList.add("baltimore");
        arrayList.add("detroit");
        for (String ele : arrayList) {
            System.out.println(ele);
        }
        System.out.println(arrayList.size());

        ⭐ TODO: — Kiểm tra hai Set có chung phần tử hay không
        Tạo 2 HashSet:
        Set<String> setA = {"A", "B", "C"};
        Set<String> setB = {"C", "D", "E"};
        -> Print yes (trung phan tu C)
        Hãy viết đoạn code dùng HashSet để kiểm tra xem setA và setB có phần tử chung không
        Hint: for loop + contains
 */
//        HashSet<String> setA = new HashSet<>();
//        setA.add("a");
//        setA.add("b");
//        setA.add("x");
//        HashSet<String> setB = new HashSet<>();
//        setB.add("x");
//        setB.add("d");
//        setB.add("e");
        // Cho 1 array 5 phan tu {2,4,6,8,9}, kiem tra xem tat ca so trong array co phai so chan hay khong, neu co in true, k in false
//        int[] array = {2, 4, 6, 8, 10};
//        boolean test = true;
//        for (int num : array) {
//            if (num % 2 != 0) test = false;
//        }
//        if (test) {
//            System.out.println("True");
//        } else {
//            System.out.println("False");
//        }
//        boolean test = false;
//        for (String eleA : setA) { // lay cac phan tu trong array dau tien
//            for (String eleB : setB) {
//                if (Objects.equals(eleA, eleB)) {
//                    test = true;
//                    break;
//                }
//            }
//
//        }
//        if (test) System.out.println("same element");
//        else System.out.println("no same element");
        /*
            ⭐ TODO: Bài 3 — Union, Intersection, Difference
            Cho 2 HashSet số nguyên:
            ⭐ A = {1, 2, 3, 4}
            ⭐ B = {3, 4, 5, 6}
            ✔ Union (A ∪ B)
            Hãy tạo 3 tập mới:
            +union (hợp)
            +intersection (giao)
            +difference (A - B)
            Không được sửa A và B gốc.
            Vi du: Tập hợp tất cả phần tử có trong A hoặc B, không trùng:
            👉 {1, 2, 3, 4, 5, 6}
            ✔ Intersection (A ∩ B)
            Tập hợp phần tử xuất hiện trong cả A và B:
            👉 {3, 4}
            ✔ Difference (A - B)
            Các phần tử có trong A nhưng không có trong B:
            👉 {1, 2}
         */
        HashSet<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        HashSet<Integer> setB = new HashSet<>(Arrays.asList(3, 4, 5, 6));
        HashSet<Integer> setUnion = new HashSet<>(setA);
        setUnion.addAll(setB);
        System.out.println(setUnion);

        HashSet<Integer> setIntersection = new HashSet<>();
        // Push vào setIntersection
        for (Integer ele : setA) {
            for (Integer ele1 : setB) {
                if (Objects.equals(ele, ele1)) setIntersection.add(ele);
            }
        }
        System.out.println(setIntersection); // [3,4]
        // setA {1,2,3,4}
        // setB {3,4,5,6}

        HashSet<Integer> setDifference = new HashSet<>(); // [1,2]
        for (Integer ele1 : setA) { // [1,2,3,4]
            if (!setB.contains(ele1)) { //
                setDifference.add(ele1);
            }
        }
        System.out.println(setDifference);

    }
}

