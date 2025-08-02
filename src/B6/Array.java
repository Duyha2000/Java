package B6;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        //        https://docs.google.com/document/d/1h7Cvt9ILkPJwZCCObQE8QFSqnejyJ2b3WzRZ8Ewoh_c/edit?tab=t.0
        // NHập 10 số vào bàn phím và in 10 số đấy ra
        Scanner scanner = new Scanner(System.in);
        // 5 10 15 20

//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        int c = scanner.nextInt();
//        int d = scanner.nextInt();
//        int e = scanner.nextInt();
        // Array: list -> luu tru cac gia cung data type
        //   int[] lists = {1, 3, 6, 7, 5};  C1: Khi biet truoc gia tri array
        // index:      0  1  2  3  4
        // array_name[index]
//        System.out.println("First element: " + lists[0]);
//
//        System.out.println("third element " + lists[2]);
        // 5 elements in array -> last index = 4
//        int n = lists.length;
//        System.out.println("Length: " + n);
//        System.out.println("Last element: " + lists[n - 1]);
        // last index = n - 1 ( n is length)

        // Print all elements in array:
//        System.out.println(lists[0]);
//        System.out.println(lists[1]);
//        System.out.println(lists[2]);
//        System.out.println(lists[3]);
//        System.out.println(lists[4]);
//        for (int i = 0; i < n; i++) {
//            System.out.print(lists[i] + " ");
//        }


        int[] ages = {18, 20, 25, 30, 35};
        String[] strings = {"Hung", "Cuong", "Giang"};


        // B1: Tao 1 array gom 5 so -3 -1 0 -4 5
        // B2: In ra cac so > 0 trong array

//        int[] so = {-3, -1, 0, -4, 5};
//        System.out.println(so[0]);
        // i -> index
        // so[i] -> number
//        for (int i = 0; i < so.length; i++) {
//            if (so[i] > 0) {
//                System.out.println(so[i]);
//            }
//        }

        // B1: Tao 1 array gom 5 so 1 15 30 50 65
        // B2: In ra cac so chia het cho 3 va 5 trong array

//        int[] chia5 = {1, 15, 30, 50, 65};
//        for (int i = 1; i < chia5.length; i++) {
//            if (chia5[i] % 3 == 0 && chia5[i] % 5 == 0) {
//                System.out.println(chia5[i]);
//            }
//        }

        // Sum in array

//        int sum = 0;
//        for (int i = 0; i < chia5.length; i++) {
//            sum += chia5[i];
//        }

//        System.out.println(sum);

        // C2: Khi chua biet truoc cac gia tri:
// TODO  B1:      int[] number2s = new int[10];

//        number2s[0] = scanner.nextInt();
//        number2s[1] = scanner.nextInt();
//        number2s[2] = scanner.nextInt();
//        number2s[3] = scanner.nextInt();
// TODO   B2:    for (int i = 0; i < number2s.length; i++) {
//            number2s[i] = scanner.nextInt(); }

//  TODO  B3:    for (int i = 0; i < 10; i++) {
//            System.out.println(number2s[i]);
//        }

        // B1: Tao 1 array 5 ten input tu ban phim

        // B2: in 5 ten ra

//        String[] ten = new String[5];
//        for (int i = 0; i < ten.length; i++) {
//            ten[i] = scanner.nextLine();
//        }
//        for (int i = 0; i < ten.length; i++) {
//            System.out.println(ten[i]);
//        }
        /*
        Exercise 1: Sum All Elements in the Array
        Description: "Ask the user to input" an array of integers, then "compute the sum of all elements"
        that are "divisible by both 3 and 5" in the array.
        Example Input: 1 2 13 30 45
        Example Output: sum = 75
         */
//  TODO: B1      int n = scanner.nextInt();
//        int[] tong = new int[n]; // size of array = n

//        int sum = 0;
        // TODO B2: for input:
//        for (int i = 0; i < tong.length; i++) {
//            tong[i] = scanner.nextInt();
//        }
        // TODO: for logic:
//        for (int i = 0; i < tong.length; i++) {
//            if (tong[i] % 3 == 0 && tong[i] % 5 == 0) {
//                sum += tong[i];
//            }
//        }
//        System.out.println(sum);

        // 5 - 10 - n so B1: Input so phan tu can lam trong bai
//        int m = scanner.nextInt();
//        int[] arr = new int[m]; // 10 so
        // [- - - - - - - - - -]
        // B2:
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = scanner.nextInt();
//        }
        // [1 2 3 4 5 6 7 8 9 1]
        // B3: Tính toán


        // B1: Nhap n la so phan tu trong array
        // B2: Đếm các so > 0 và là số chăn trong array đấy


        // n = 5: -4 -6 0 2 4
        // count = 2 (2 - 4)
//        int n = scanner.nextInt(); // B1: Input n
//        int[] hh = new int[n];
//
//        for (int i = 0; i < hh.length; i++) {
//            hh[i] = scanner.nextInt();
//        }
//        int count = 0;
//        for (int i = 0; i < hh.length; i++) {
//            if (hh[i] > 0 && hh[i] % 2 == 0) {
//                count += 1;
//            }
//        }
//        System.out.println(count);

        // TODO: Exercise 5: Count the Occurrences of a Value in the Array
        //Description: Ask the user to input an array of integers and a target value.
        // Then, count and print the number of times the target value appears in the array.
        //Example Input:
        //arr = [1, 3, 3, 5, 5, 4, 5],  X = 3
        //Hint: Initialize a counter (e.g., count = 0) and increment it (count+= 1) when the condition is met.

        int a = scanner.nextInt();
        int[] ex5 = new int[a];
        int X = scanner.nextInt(); // 3
        for (int i = 0; i < ex5.length; i++) {
            ex5[i] = scanner.nextInt();
        }
        int count = 0;

        for (int i = 0; i < ex5.length; i++) {
            if (ex5[i] == X) {
                count += 1;
            }
        }
        System.out.println(count);

    }
}