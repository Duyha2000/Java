public class Main {
    public static void main(String[] args) {
        double a = 3.5, b = 2.0;
        String x = "A1X23c9xyz"; // 2
        System.out.println(countDigits(x));
        System.out.println(countUppercases(x));
        // kiem tra 1 ky tu co phai so hay ko?: ASCII | '0' < x < '9'
//        char x = '5';
//        if (x >= '0' && x <= '9') {
//            System.out.println("ky tu nay la so");
//        } else {
//            System.out.println("Ky tu nay ko phai so");
//        }

        // double result = a % b; // lay phan du ra
        // Co 3.5l nuoc:
        // Nhung chai 2 lit:
        // chai dau tien chua full nuoc: 2 lit
        // chai thu 2 se con: 1.5
        // 10 can gao:
        // cac cai hu dung gao (moi hu 3 kg)
        // 3 bao
        // du 1kg -> do vao them 1 bao
//        System.out.println(result);

//        System.out.println(remainder(a, b));
        // in ra 5 ky tu dau tien: start - end
//        System.out.println(x.substring(x.length() - 1));
//        System.out.println(x.substring(0, x.length() - 1));

//        System.out.println(x.substring(1)); // start index: ello
        // cat chuoi tu vi tri index -> ello
        // lay ra cac ky tu tu cuoi len dau
        // o l l e h
//        System.out.println(); // lay ra ky tu 'o' bang substring:
//        System.out.println(x.substring(x.length() - 1));
        //  lay ra ky tu 'e' bang substring:
//        System.out.println(x.substring(4, 5)); // e
//        System.out.println(x.substring(3, 4)); // l
// in ra chuoi dao nguoc bang substring -> dung vong lap for:
//        String result = "";
//        // substring(begin, end)
//        for (int i = x.length() - 1; i >= 0; i--) result += x.substring(i, i + 1);
//        System.out.println("Result " + result);
    }

    // hello
    // o + reverse(...) 'hell'
    // o + l + reverse(...)
    // o + l + l + reverse(...)
    // o + l + l + reverse(...)
    // o + l + l + e +reverse(...)
    //o + l + l + e + h +reverse(...)
    static void reverse(String s) {
        if (s.isEmpty()) return;
        else {
            char lastChar = s.substring(s.length() - 1).charAt(0);
            System.out.print(lastChar); // in ra ky tu cuoi cung: o // In | tinh count,sum

            reverse(s.substring(0, s.length() - 1)); // goi de quy voi phan con lai: reverse(hell)
        }
    }

    /*
    🟡 BÀI 2 (Khó hơn chút)
        Đề:
        Viết hàm đệ quy đếm số chữ số (0–9) trong một chuỗi bằng substring.
        Ví dụ:
        Input:  "a1b23c9xyz"
        Output: 4 ( 4 so)
        isNumber() -> check có phải số hay k, nếu là số +1
        Hint: countDigits(String s)
        🔹 Điều kiện dừng (base case)
        Khi chuỗi rỗng → không còn gì để đếm → trả về 0.

        ->  Count:  1 + recursive(...) -> trong recursive

        Cac bai lien quan substring:
        B1: lay ky tu cuoi -> in | check dieu kien (so, chu, ky tu dac biet)
        B2: noi phan con lai bang de quy

        TODO: đếm số ký tự in hoa (A–Z) trong một chuỗi, chỉ được dùng substring(), không dùng vòng lặp.
     */
    static int countUppercases(String s) {
        if (s.isEmpty()) return 0;
        else {
            char lastChar = s.substring(s.length() - 1).charAt(0);
            if (lastChar >= 'A' && lastChar <= 'Z')
                return 1 + countUppercases(s.substring(0, s.length() - 1));
            else return countUppercases((s.substring(0, s.length() - 1)));
        }
    }

    static int countDigits(String s) {
        if (s.isEmpty()) return 0;
        else {
            char lastChar = s.substring(s.length() - 1).charAt(0);
            if (lastChar >= '0' && lastChar <= '9') {
                return 1 + countDigits(s.substring(0, s.length() - 1));
            } else {
                return countDigits(s.substring(0, s.length() - 1));
            }

        }

    }

//    static double remainder(double x, double y) {
//        if (x < y)
//            return x;
//        return remainder((x - y), y);
//    }

    // 10 - 3 = 7  || 5.5 - 2 = 3.5
    // 7 - 3 = 4 ||
    // 4 - 3 = 1

    // 3.5 / 2.0 = 1.75 -> 'would be: 1.5'

    // 8 / 3 = (2 * 3) + '2'
    // 8 - 3 = 5 L0:
    // 5 - 3 = '2' L1
    // 2 - 3 = -1 (dung de quy)

    // 4 * 1 = 4
    // 4 * 2 = 8 -> 4 + 4
    // x = 10, y = 4
    // 10 / 4 ->
    // 10 - 4 = 6
    // 6 - 4 = '2' (stop here)
    // 2 - 4 -----
//    static int modulus(int x, int y) {
//        if (x < y) // finish draft
//            return x;
//
//        return modulus(x - y, y);
//    }

    // 4 * |7| + 3 = 31
    // 31/3 = (3 * 10 )+ 1
    // Based on: x = 31 -> y = 3, count = 0
    // 31 - 3 = 28 -> count = 1
    // 28 - 3 = 25 -> count = 2
    // 25 - |3| = 22
    // 5 - 3 = 2 -> count = 10 [1 + ...]
    // 2 - 3 < 0 -> return 0
    // dem so luong chu so cua 1 so: "count"
    //  static int modulus(int x, int y) {
    //    if (x < y) return 0;
    //   return 1 + divide((x - y), y);
}
// 1 + divide(28,3)
// 1 + 1 + divide(25,3)
//...
    /*
    4 / divide(3)
    4 / 4 / divide (5)

     */

// VIết 1 hàm de quy tinh tong cac so tu 1 -> 5:
// 1 + 2 + 3 + 4 + 5 = 15
// int total(int n) {
//   if (n == 0)
//     return 0;
//return n + total(n - 1);
//}
   /* static int add(int x, int y) {
        if (y == 0)
            return x;
        return x + add(x, y - 1);
*/

    /* 1 + add(1)
    1 + 1 + add(0)
    1 + 1 + 1  + add(0-1)
    return x == 3;

     */
    /*
    return 5 + total(4)
    5 + 4 + total(3)
    5 + 4+ 3 + total(2)
    5+ 4 + 3 + 2 + total(1)
    5 + 4 + 3 + 2 + 1 + total(0)
    5 + 4 + 3 + 2 + 1 + 0 --> return 0
     */
