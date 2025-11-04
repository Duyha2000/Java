import java.util.Scanner;

public class Recursion {
//    public static int sum(int n) {

    /// /        int sum = 0;
    /// /        for (int i = n; i >= 0; i--) {
    /// /            sum += i;
    /// /        }
    /// /        return sum;
//
//        // B2: Dieu kien dung:
//        if (n == 0) return 0;
//
//        // B1: Phan de quy
//        // 5 + 4 (sum (n-1) + 3 + 2 + 1 + 0
//        return n + sum(n - 1);  // 5 + sum(4)
//        // 5 + 4 + sum(3)
//        // 5 + 4 + 3 + sum (2)
//        // 5+ 4 + 3+ 2 + sum (1)
//        // 5 + 4 + 3 + 2 + 1 + sum (0) // stop !!
//        // n == 0: condition - gia tri khoi tao (sum) -> return gia tri bat dau
//
//        // B1: n: gia tri khoi tao - (n - 1) (step)
//
//    }
    public static int factorial(int n) {
//        int 'count = 1'; step 1
//        for (int i = n; 'i >= 1 step 1'; i--) {
//            count *= i;
//        }
//        return count;
        // B2: Dieu kien dung:
        if (n == 1) return 1;
        // B1: Phan de quy
        return n * factorial(n - 1);
    }

    //  Cho số nguyên n được nhập từ bàn phím, bạn hãy viết hàm đệ quy trả về tổng các số lẻ > 0 từ 1 tới n.
//    public static int totalOdd(int n) {

    /// /        int sum = 0;
    /// /        for (int i = n; i >= 1; 'i--') {
    /// /            if (i % 2 != 0) sum += i;
    /// /        }
    /// /        return sum;
//        // B2: Dieu kien dung:
//        if (n == 1) return 1;
//        // B1: Phan de quy:
//        if (n % 2 == 0) totalOdd(n - 1); //
//        return n + totalOdd(n - 1); //
//    }
    // base = 2 , exponent = 3
//    public static int exponentiation(int base, int exponent) {

    /// /        int result = 1;
    /// /        for (int i = exponent; i >= 1; i--) result *= base;
    /// /        return result;
//        if (exponent == 0) return 1; // B2: dieu kien dung
//        return base * exponentiation(base, exponent - 1);
//        // B1: 2 * expo(2, 2)
//        // b2: 2 * 2 * expo (2, 1)
//        // b3: 2 * 2 * 2 * expo (2,0) = 8
//    }
    // tính tổng các số trong array:
//    public static int sumOfArray(int[] arr, int size) {

    /// /        int sum = 0;
    /// /        for (int i = size - 1; i >= 0; i--) sum += arr[i];
    /// /        return sum;
    /// /        if (size == 0) return 0;
    /// /        if (size == 1) return arr[0];
//        // arr[4] + arr[3] + arr[2] + arr[1] + arr[0] ->
//        if (size == 1) return arr[0];
//        return arr[size - 1] + sumOfArray(arr, size - 1); // size = 5
//        // B1: arr[4] + sum(arr, 4)
//        // b2: arr [4] + arr[3] + sum(3)
//        // b3 arr [4] + arr[3]  + arr[2] + sum(2)
//        // b4: arr [4] + arr[3] + arr[2] + arr[1] + 'sum(1)' ->
//        // b5 : arr [4] + arr[3] + arr[2] + arr[1] + arr[0]
//    }
//    public static int countNumber(int n) {
//        int count = 0;
//        while (n > 0) {
//            n = n / 10;
//            count++;
//        }
//        for(int i = n; i > 0; i = i/10) count++;
//        return count;
    // B1: 19845 / 10 = 1984 (count = 1)
    // B2: 1984 / 10 = 198 (count = 2 )
    // B3: 198 / 10 = 19 (count = 3)
    // B4: 19 / 10 = 1 (count = 4)
    // 1 / 10 = '0' (count = 5)
//        if (n == 0) return 0;
//        return 1 + countNumber(n / 10); // 1 + ...
    // b1: 1 + count(19845 / 10) --> 1 + 1
    // b2: 1 + 1 + 1 + count(1984/10) --> 1 + 1 + 1 p

//    }
    public static int sumNumber(int n) {
//        int sum = 0;
//        while (n > 0) {
//            sum += n % 10; // 5
//            // 1984
//            n /= 10; // n = n/ 10
//        }  for( int i = n; i > 0; i/=10) sum += n%10;
//        ...)
        if (n == 0) return 0;
        return n % 10 + sumNumber(n / 10);
        // b1: 5 + sum(1984)
        // b2: 5 + 4 + sum(198)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(sumNumber(19845));
//        int n = scanner.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
//        System.out.println(sumOfArray(arr, n));
        /*
        TODO: Đếm số chữ số của một số nguyên dương n - > Ví dụ: n = 19845 → 5 chữ số (while)
        TODO:Tính tổng các chữ số của một số nguyên dương n -> Ví dụ: n = 1234 → 1+2+3+4 = 10
        TODO: Đảo ngược một số nguyên dương n - > Ví dụ: n = 1234 → 4321
         */
    }
}
