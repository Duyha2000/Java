package B4;

import java.util.Scanner;

public class Condition {
    public static void main(String[] args) {
        // https://docs.google.com/document/d/1IiCAHcVbdgo_P3UB3dibkdjwODVcDKLippU516uv7qw/edit?tab=t.0
        /*
        TODO:
         1. Exercise 1: Print numbers from 1 to "N"
          Problem: Write a program to print all integers from 1 to N (entered from the keyboard).
          Input: N = 5
          Output: 1 2 3 4 5
             int N = scanner.nextInt();
            // int i = ... ; i<= ; i++
            // Thiếu: int
            // Không dùng , => ;
            // syntax: {}
            for (int i = 1; i <= N; i++) {
                System.out.println(i);
            }
          2. Exercise 2: Print even numbers from 1 to N
          Problem: Input a positive integer N, print all even numbers from 1 to N.
          Input: N = 10
          Output: 2 4 6 8 10
          int N = scanner.nextInt();
            for (int i = 1; i <= N; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
           3. Exercise 3: Print numbers from N down to 1
          Problem: Input a positive integer N, print all numbers from N down to 1.
          Input: N = 5
          Output: 5 4 3 2 1
          int N = scanner.nextInt();
            for (int i = N; i >= 1; i--) {
                System.out.println(i);
            }
            4. Exercise 4: Print the multiplication table of a number
              Problem: Input an integer N, print the multiplication table of N from 1 to 10.
              Input: N = 7
              Output:
                7 x 1 = 7
                7 x 2 = 14
                ...
                7 x 10 = 70
              int N = scanner.nextInt(); // N = 7
                   System.out.println(N + "* " + 1 + "= " + (N * 1));
                  System.out.println(N + "* " + 2 + "=" + (N * 2));
                    for (int i = 1; i <= 10; i++) {
                        // in ra 10 dòng:
                        System.out.println(N + "*" + i + "=" + (i * N));
                    }
            II. TYPE 2: Accumulation Calculations
            5. Exercise 5: Calculate the sum from 1 to N
              Problem: Input an integer N, calculate the sum from 1 to N.
              Input: N = 4
              Output: Sum = 10

           1/ int sum = 0;
           2/ for() => sum += i
           3/ print sum (out loop)
             int N = scanner.nextInt();
             int sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += i;
            }
            System.out.println(sum);

           6. Exercise 6: Calculate the factorial(giai thừa) of N
          Problem: Input a positive integer N, calculate N! (N factorial).
          Input: N = 5
          Output: Factorial = 120
            5! = "5 * 4 * 3 * 2 * 1" = 120
            4! = 4 * 3 * 2 * 1 = 24
          int N = scanner.nextInt();
        int multiple = 1;
        for (int i = N; i >= 1; i--) {
            multiple *= i;
        }
        System.out.println(multiple);

        III. TYPE 3: Conditional Counting
        7. Exercise 7: Count multiples of 3 from 1 to N
          Problem: Input an integer N, count how many numbers from 1 to N are divisible by 3.
          Input: N = 20
          Output: There are 6 numbers divisible by 3
   Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (i % 3 == 0) {
                count++;
            }
        }
        System.out.println(count);

        8. Exercise 8: Count even and odd numbers from 1 to N
            Problem: Input a positive integer N, count how many even are in the range 1 to N.
            Input: N = 10
            Output:
            Even numbers: 5
             int count = 0;
        int N = scanner.nextInt();
        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) {
                count++;
            }
        }
        System.out.println(count);

            9. Exercise 9: Count numbers divisible by both 3 and 5
              Problem: Input an integer N, count how many numbers from 1 to N are divisible by both 3 and 5.
              Input: N = 30
              Output: There are 2 numbers divisible by both 3 and 5
               int count = 0;
        int N = scanner.nextInt();
        for (int i = 1; i <= N; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                count++;
            }
        }
        System.out.println(count);


        10. Exercise 10: Count the number of divisors of N
          Problem: Input a positive integer N, and count how many divisors it has.
          Input: N = 12
          Output: There are 6 divisors


         8 : 1
         8 : 2
         8 : 4
         8 : 8
          int count = 0;
        int N = scanner.nextInt(); // 12
        for (int i = N; i >= 1; i--) {
            if (N % i == 0) {
                count++;
            }
        }
        System.out.println(count);

        IV. TYPE 4: Using break and continue
        // In ra số "đầu tiên" chia hết cho 3 và 5 từ 1 đến 50
        // break: dừng lại (thoát vòng lặp)
        for (int i = 1; i <= 50; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i); // 15
                break;
            }
        }

        11. Exercise 11: Stop printing when encountering a multiple of 7
          Problem: Input an integer N, print numbers from 1 to N. Stop printing if a number divisible by 7 is found.
          Input: N = 10
          Output: 1 2 3 4 5 6
          for (int i = 1; i <= N; i++) {
            if (i % 7 == 0) {
                break;
            }
            System.out.println(i);
        }

          13. Exercise 13: Find and print the first number divisible by both 4 and 6
          Problem: Input an integer N, find the first number in range 1 to N divisible by both 4 and 6, then stop the loop.
          Input: N = 30
          Output: First number divisible by both 4 and 6 is: 12
             int N = scanner.nextInt();
        for (int i = 1; i <= N; i++) {
            if (i % 4 == 0 && i % 6 == 0) {
                System.out.println(i);
                break; // in ra roi thoat
            }
        }

        15. Exercise 15: Stop when the sum exceeds a limit
          Problem: "Input two integers" N and LIMIT. Add numbers from 1 to N. 'If' the sum exceeds LIMIT, "stop" adding and print the current sum.
          Input: N = 10, 'LIMIT = 20'
          Output: Sum exceeded at value: 6 ('Sum' = 21)
                1 + 2 + 3 + 4 + 5 + 6 = 21
         */
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int N = scanner.nextInt();
        int LIMIT = scanner.nextInt();
        // Tinsh toong cho ddeens khi sum > limit thi dung lai
        for (int i = 1; i <= N; i++) {
            sum += i;
            if (sum > LIMIT) {
                break;
            }
        }

        System.out.println(sum);
    }
}
