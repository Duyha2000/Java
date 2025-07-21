package B3.Lecture;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //  https://docs.google.com/document/d/1ESB8fY-5GSJi65RTXlDRnXS7UQlVXVzip07nS6JCVIc/edit?tab=t.0#heading=h.28tx88f7t32x

        // Unary operators : ++ -- += -= *= /=

//        int a = 3;
//        System.out.println(a);
        // Tang gia tri a
        // ++:
//        int b;

        // a++; // increase by 1
//        a = (a + 2); // 5
        // giam gia tri a 3 don vi
        // a = a - 3; // a -= 3
        // a [- ->=] 3; //
//        a -= 3;

        // Tăng 1, giảm 1: ++ -- => vòng lặp for
        // Tăng/ giảm nhiều đơn vị:  +=  || a = a + ...
//        System.out.println(a);

        // In ro số 5  100 lần
//        System.out.println(5);
//        System.out.println(5);
//        System.out.println(5);
//        System.out.println(5);
//        System.out.println(5);
//        System.out.println(5);
//        System.out.println(5);
//        System.out.println(5);
//        System.out.println(5);
//        System.out.println(5);
        // In ra các số tu 1 -> 10

        // Loops: for (*) - while - do while
        /*
        for( int i = initValue      ;  i >= ... expression       ; updateValue i++  ){
//                code here
            }
            [0-> 1 2 3 4 5 6 7 8 9]
         */
//        for (int i = 0; i <= 9; i++) {
//            System.out.println(5);
//        }

        // In ra các số từ 1 -> 5 ( 1 2 3 4 5  )
//        for (int i = 1; i < 11; i++) {
//            System.out.println(i); // 1 2 3 4 5
//        }

        // In ra các số tu 5 về -5 (5 4 3 2 1 0 -1 -2 -3 -4 -5) [-6]
//        for (int i = 5; i >= -5; i--) {
//            System.out.println(i);
//        }
        // IN ra các số "chẵn" từ 1 đến 20

//        for (int i = 1; i <= 20; i++) {
//            if (i % 2 == 0) {
//                System.out.println(i);
//            }
//        }

        // In ra các số chia hết cho 3 và 5 trong khoảng từ 0 -> 20

//        for (int i = 0; i <= 20; i++) {
//            if (i % 3 == 0 && i % 5 == 0) {
//                System.out.println(i);
//            }
//        }
        // Tính tổng các số từ 1 đến 5 ( 1 + 2 + 3 + 4 + 5 -> sum = 15)
//        int sum = 0; //

//        sum += 1;
//        sum += 2;
//        sum += 3;
//        sum += 4;
//        sum += 5;
//        for (int i = 1; i <= 5; i++) {
//            sum += i;
//        }
//        System.out.println(sum);

        // Note: sum = 0 -> sum += i;

        // Tính tổng các số chia hết cho 3 hoặc 7 trong khoảng từ 1 - 20
        // Không in sum bên trong vòng lặp for
//        int sum = 0;
//        for (int i = 1; i <= 20; i++) {
//            if (i % 3 == 0 || i % 7 == 0) {
//                sum += i;
//            }
//        }
//        System.out.println(sum);

        /*
        Exercise 2: Numbers Divisible by 3 and 5
        Task: Write a program that takes two integers a and b and displays all numbers between them divisible by both 3 and 5.
        Steps:
        Input two integers a and b.
        Loop through numbers from a to b.
        Check if each number is divisible by both 3 and 5.
        Print the valid numbers.
        Input:
        Two integers a and b (e.g., 1 and 50).
        Output:
        All numbers = divisible by both 3 and 5 (e.g., [15 30 45]).
        => a | b => input from keyboard

        a = 1
        b = 50
        1 - > 50 (check condition)
         */
//
//
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt(); // 1
//        int b = scanner.nextInt(); // 50
//        // i: 1 => 50 (15 30 45)
//        int sum = 0;
//
//        for (int i = a; i <= b; i++) {
//            if (i % 3 == 0 && i % 5 == 0) {
//                System.out.println(i);
//                sum += i;
//            }
//        }
//        System.out.println(sum);


        /*
        TODO:
        Exercise 3: Calculate the Sum of Numbers from 1 to N
        Write a program to calculate the sum of all integers from 1 to N, where N is a positive integer.
        Use a for loop to iterate through the numbers and accumulate their sum in a variable.
        Example: If N = 10, the sum is 1 + 2 + 3 + … + 10 = 55.
        //        int sum = 0;
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        for (int i = 0; i <= N; i++) {
//            sum += i;
//        }
//        System.out.println(sum);
         */
        //        Đếm các số chẵn trong khoảng from 1 -> to 10 (2 4 6 8 10 (5 chan)
        // sum = 0 => sum += i => Print sum
        // count = 0 => Condition: count++ => Print count
//        int count = 0;
//        for (int i = 1; i <= 10; i++) {
//            if (i % 2 == 0) {
//                count++;
//            }
//        }
//        System.out.println(count);
        /*
        Exercise 4: Count Numbers Divisible by X
        Write a program to count how many numbers are divisible by X in the range from A to B,
        where A <= B, and X is a positive integer. Use a for loop to check each number in the range.
        Example: If A = 1 , B = 50, and X = 5, there are 10 numbers divisible by 5:
        5,10,15,...,50
            [A = 1  B = 50]
            X = 5
            5 10 15 20 25 .... => 10 lan = count
         */
//        int A = scanner.nextInt(); // 1
//        int B = scanner.nextInt(); // 50
//        int X = scanner.nextInt(); // 5
//        int count = 0;
//        for (int i = A; i <= B; i++) {
//            if (i % X == 0) {
//                count++;
//            }
//        }
//        System.out.println(count);

        //    Tinh tich cac so tu 1 -> 5
//        int mutiple = 1; //
//        for (int i = 1; i <= 5; i++) {
//            mutiple *= i;
//        }
//        System.out.println(mutiple);
        /*
        Exercise 6: Count Divisors
            Task: Write a program that inputs an integer n and displays "the number of" its divisors.
            Steps:
            Input an integer n.
            Loop through numbers from 1 to n.
            Check if each number divides n evenly.
            Count and print the divisors.

            Input:
            An integer n (e.g., 12).

            Output:
            Number of divisors (e.g., 6 for 12).
            12: [1 2 3 4 6 12] = 6
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 12
        int count = 0;
        // count = 0 => Condition: count++ => Print count
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
