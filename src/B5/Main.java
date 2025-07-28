package B5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // https://docs.google.com/document/d/1n4n52y7RjgHDgp8qLMpNg1Fqi0CQp2zodFrFjWFNrOk/edit?tab=t.0
        // if else if else

        // switch: thay dổi - case: trường hợp
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Input choice: ");
//        int choice = scanner.nextInt();
//        switch (choice) {
//            case 0:
//                System.out.println("Sunday");
//                break;
//            case 1:
//                System.out.println("Monday");
//                break;
//            // write here
//            default:
//                System.out.println("Invalid");

                /*
            TODO:    1 người ra đường và đứng ở biển báo giao thông và có 3 lựa chọn (GỢi ý : initialize String choice)
                    Nếu gặp đèn đỏ thì dừng lại => In ra stop
                    Nếu gặp đèn vàng thì đi chậm => In ra slow
                    Nếu gặp đèn xanh thì đi tiếp  => In ra pass
                    Trường hợp còn lại in ra: “Bạn đã bị công an bắt”
            */
//        Scanner scanner = new Scanner(System.in);
//        String choice = scanner.nextLine();
//        switch (choice) {
//            case "do":
//                System.out.println("stop");
//                break;
//            case "vang":
//                System.out.println("slow");
//                break;
//            case "xanh":
//                System.out.println("pass");
//                break;
//            default:
//                System.out.println("bi bat");
        /*
            Problem 3: Grade classification: Input an integer score (ranging from 0 to 100) and classify the grade:
                    "Weak" if score <= 50.
                    "Average" if 50 < score <= 60.
                    "Good" if 60 < score <= 75.
                    "Very Good" if 75 < score <= 90.
                    "Excellent" if the score is > 90.

            Problem 6: Perform basic arithmetic: Input two integers a and b and a character c from the keyboard representing
            an arithmetic operation (+, -, *, /). Calculate and print the result. Example:
            If a = 7, b = 9, and c = '+', print: 16.
            Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        String c = scanner.nextLine();

        switch (c) {
            case "+":
                System.out.println(a + b);
                break;
            case "-":
                System.out.println(a - b);
                break;
            case "*":
                System.out.println(a * b);
                break;
            case "/":
                System.out.println(a / b);
                break;
            default:
                System.out.println("invalid");
                1 -> 5 (start, end => lặp bao nhiêu lân)
                "do while" / while
                https://docs.google.com/document/d/1ESB8fY-5GSJi65RTXlDRnXS7UQlVXVzip07nS6JCVIc/edit?tab=t.0#heading=h.28tx88f7t32x
         */
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Show menu");
//        System.out.println("1. Coke $1.75");
//        System.out.println("2. Pepsi $1.25");
//        System.out.println("3. Water $2");
//        System.out.println("4. Coffee $1.5");
//        System.out.println("5. Exit menu");
//        System.out.println("Enter your choice:");
//        int choice;
//        // do - while
//
//        do {
//            choice = scanner.nextInt(); // input
//            switch (choice) {
//                case 1:
//                    System.out.println("1. Coke $1.75");
//                    break;
//                case 2:
//                    System.out.println("2. Pepsi $1.25");
//                    break;
//                case 3:
//                    System.out.println("3. Water $2");
//                    break;
//                case 4:
//                    System.out.println("4. Coffee  $1.5");
//                    break;
//                case 5:
//                    System.out.println("5. Exit menu");
//                    break;
//                default:
//                    System.out.println("Invalid");
//            }
//        } while (choice != 5);
//        Scanner scanner = new Scanner(System.in);
//        int choice;
//        do {
//            System.out.println("1.Calculate the perimeter and area of a rectangle.\n" +
//                    "2.Calculate the perimeter and area of a triangle.\n" +
//                    "4.Exit.");
//            System.out.println("Enter your choice: ");
//            choice = scanner.nextInt();
//            switch (choice) {
//                case 1: {
//                    System.out.println("Enter height: ");
//                    int height = scanner.nextInt();
//                    System.out.println("Enter width: ");
//                    int width = scanner.nextInt();
//                    System.out.println("Area:" + (height * width));
//                    System.out.println("Perimeter: " + (2 * (height + width)));
//                    break;
//                }
//                case 2: {
//                    System.out.println("Enter cao 3");
//                    int cao3 = scanner.nextInt();
//                    System.out.println("Enter cao 2");
//                    int cao2 = scanner.nextInt();
//                    System.out.println("Enter cao 1");
//                    int cao = scanner.nextInt();
//                    System.out.println("Perimeter:" + (cao + cao2 + cao3));
//                }
//
//                case 4: {
//                    System.out.println("Exit");
//                    break;
//                }
//                default:
//                    System.out.println("Invalid");
//            }
//        }
//        while (choice != 4);
        // Exercise 13: Validate User Input
        // [0 - 120]

        // Validate value:
        Scanner scanner = new Scanner(System.in);
//        int age;
//        do {
//            System.out.println("Input age:");
//            age = scanner.nextInt();
//            if (age > 120 || age < 0) {
//                System.out.println("Invalid");
//            }
//        } while (age > 120 || age < 0);
//
//        System.out.println("Age: " + age);

        // Nhập 1 số vào bàn phím và kiểm tra số nhập vào có > 0 hay không, nếu < 0 bắt nhập lại. Nếu > 0 thì in ra số này > 0
//        int so;
//        do {
//            so = scanner.nextInt();
//            if (so < 0) {
//                System.out.println("Nhap lai: ");
//            }
//        } while (so < 0);
//        System.out.println(so);
//
        int random = 57;
        // while

        int X;
        do {
            X = scanner.nextInt();
            if (X > random) {
                System.out.println("too high!");
            } else if (X < random) {
                System.out.println("too low!");
            } else {
                System.out.println("bingooo!");
            }
        } while (X != random);
    }
}