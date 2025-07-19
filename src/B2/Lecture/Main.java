package B2.Lecture;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // https://docs.google.com/document/d/1n4n52y7RjgHDgp8qLMpNg1Fqi0CQp2zodFrFjWFNrOk/edit?tab=t.0

        // Data types:

        // int: 4 5 6 - double/float: 4.5 5.7 6.9
        // [4,5 5,7]

        // char: 'h' 'e' 'm' -> ''
        // String: "hem" => " "
        // bool: true/false

        // camelCase: fullName

        // input: 2 cách

//
//        int number = scanner.nextInt();
//        double number2 = scanner.nextDouble();
//        String str = scanner.nextLine();
//        boolean isCheck = scanner.nextBoolean();
//        // Operators: + - * / %
//
//        // "hello" => Bắt đầu từ ký tự 0
//        char c = scanner.nextLine;().charAt(0)

        // Condition: if - else if - swtich case - || && !

        // Nếu em thi >= 5 điểm -> đậu, ngược lại rớt
//        double score = 5.5;
//        if (score >= 5) {
//            System.out.println("Đậu");
//        } else {
//            System.out.println("Rớt");
//        }
        // Nhập vào 1 số nguyeên, check số đấy > 0 hay không

        // Đúng: số này > 0
        // Sai: số này < 0

//        Scanner scanner = new Scanner(System.in);
//        int so = scanner.nextInt(); // B1: Input
//        if (so > 0) {
//            System.out.println("so nay >0");
//        } else if (so == 0) {
//            System.out.println("Số này = 0");
//        } else {
//            System.out.println("so nay < 0");
//        }
        /*
            Problem 2: Compare the salaries of two people:
            Input the salaries of two people from the keyboard.
            Compare and print:
            "person1" if the first person has a higher salary.
            "person2" if the second person has a higher salary. Requirements:
            Use if/else.
         */
//        Scanner scanner = new Scanner(System.in);
//        double firstP = scanner.nextDouble();
//        double secondP = scanner.nextDouble();

        // 3 dieu kien: if - else
        // > 3 dieu kien: else if
//        if (firstP > secondP) {
//            System.out.println("người 1 luong cao hơn nè");
//        } else if (firstP == secondP) {
//            System.out.println("Lương bằng nhau");
//        } else {
//            System.out.println("nguoiwf 2 hon");
//        }
        // Dùng "==" cho if, else if
        /*
        TODO:
            – If 0 ≤ Score < 6, grade F  | Nếu điểm >=0 "và" < 6
            – If 6 ≤ Score < 7, grade D
            – If 7 ≤ Score < 8, grade C
            – If 8 ≤ Score < 9, grade B
            – If 9 ≤ Score ≤ 10, grade A
            => Nhập 7 điểm  => grade C

            if ()           1
            else if()       2,3,4,5,6
            else            end

            &&: "và"

             Scanner scanner = new Scanner(System.in);
        double score = scanner.nextDouble();

        if (0 <= score && score < 6) {
            System.out.println("F");
        } else if (6 <= score && score < 7) {
            System.out.println("D");
        } else if (7 <= score && score < 8) {
            System.out.println("C");

        } else if (8 <= score && score < 9) {
            System.out.println("B");
        } else if (9 <= score && score <= 10) {
            System.out.println("A");
        } else {
            System.out.println("Invalid");
        }

        Problem 1:
            Check if a number is even or odd:
            Write a program to check if an integer n entered from the keyboard is even or odd.
            If it's even, print: "Even number".
            If it's odd, print: "Odd number".
            Requirements: Use if/else.


            %: chia lấy phần dư:
            14 : 3 = 4 du 2 => 14 '%' 3 = 2
            Trong if, else if: 90% => %    "=="

            Odd number: 1 3 5  7 9
            Even number: 2 4 6 8 10

            2 : 2 = 1 du 0          % 2 == 0
            4 : 2 = 2 du 0
            6: 2 = 3 du 0
            ...

         Scanner sc = new Scanner(System.in);
                int a = sc.nextInt();
                if (a % 2 == 0) {
                    System.out.println("Even number");
                } else {
                    System.out.println("Odd number");
                }
            Nhập vào 1 số, kiểm tra số đấy có "chia hết cho 3 và 5" hay khng
            Nếu có: in ra chia het 3 va 5
            Neu khong: in ra ko chia het
            VD: 45 => chia het
            40 => ko chia het 3 va 5

            int a = scanner.nextInt();
        if (a % 3 == 0 && a % 5 == 0) {
            System.out.println("chia het");
        } else {
            System.out.println("Ko chia het");
        }

**** Check if a year is a leap year:
Input an integer year from the keyboard and determine if it's a leap year.
Print: "Year <year> is a leap year!" if it is.
Print: "Year <year> is not a leap year!" if it isn’t.
'Rules': A year is a leap year if it is "divisible by 4" "but not divisible by 100", or "it is divisible by 400".
         */
//        Scanner scanner = new Scanner(System.in);
//        int year = scanner.nextInt();
//        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
//            System.out.println("this is a leap year");
//        } else {
//            System.out.println("Not a leap year");
//        }
        /*
            Problem 5: Print the name of the day of the week.
            Input an "integer from 0 to 6" and print the corresponding day name:
            0: "Sunday".
            1: "Monday".
            2: "Tuesday".
            3: "Wednesday".
            4: "Thursday".
            5: "Friday".
            6: "Saturday".
            VD:  choice = 4 => Thursday
                 choice = 6 => Saturday
                 choice = -1 => Invalid
                 if
                 else if
                 else
         */
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt(); // phep gan

        // a = 4 -> Gán số 4 cho biến a

        // khi so sánh 2 điều kiện ==

        // x = 4 y = 4

        // x == y
//        if (a == 0) {
//            System.out.println("Sunday");
//        } else if (a == 1) {
//            System.out.println("Monday");
//        } else if (a == 2) {
//            System.out.println("Tuesday");
//        } else if (a == 3) {
//            System.out.println("Wednesday");
//        } else if (a == 4) {
//            System.out.println("Thursday");
//        } else if (a == 5) {
//            System.out.println("Friday");
//
//        } else if (a == 6) {
//            System.out.println("Saturday");
//        } else {
//            System.out.println("Invalid");
//        }
        /*
        Problem 6: Perform basic arithmetic:
        Input two integers a and b and a character c from the keyboard representing an
        arithmetic operation (+, -, *, /). Calculate and print the result. Example:
        If a = 7, b = 9, and c = '+', print: 16.
         Requirements:

         Input: int a , b
                char c ( + - * /)     ''
                c -> + => print(a +b)
                c -> - => print(a-b)
         */

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        char c = scanner.nextLine().charAt(0);
        int b = scanner.nextInt();


        if (c == '-') {
            System.out.println(a - b);
        } else if (c == '+') {
            System.out.println(a + b);
        } else if (c == '*') {
            System.out.println(a * b);
        } else if (c == '/') {
            System.out.println(a / b);
        } else {
            System.out.println("Invalid");
        }


        // Notes: == - %  - || or - &&  and - !=
    }
}
