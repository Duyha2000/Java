package B1.Lecture;

import java.util.Scanner;

// Docs: https://docs.google.com/document/d/1kdC5oPRjuIz4HdHA5GPfltnDnFRjW7iijZf49CjW0CE/edit?tab=t.0
public class Main {
    // function/ method
    public static void main(String[] args) {

//        System.out.println("Xin chào");
//
//        System.out.println("Tạm biet!");
//        // variable:
//
//        // luu tru gia tri
//
//        // tam giac: canhthu1, canhthu2, canhthu3
//
//        // x y z
//        // TODO: [data_type] variable_name = value;
//
//        /* TODO: data_type:
//            - int: integer: số nguyên: 3, 4, 5, 6 ,7, 0, -1
//            - double/[float]: 3.45, 4.56 , 5.78
//            - boolean: true/ false
//            - char: 'h', 'e','l','l','o'
//            - String: "hello"
//
//            Tuổi = '18'
//            Khởi tạo 1 biến là điểm -> giá trị là 6.78
//
//            "Họ và tên" => fullname, full name, FullName
//
//            => Quy uoc dat ten bien: camelCase (ky tu 1 viet thuong, ky tu sau viet hoa, viet lien nhau)
//             int age = 18;
//        double score = 6.78; //
//        String fullName = "Tran Duc A";
//        boolean isDarkMode = true;
//         */
//
//
//        /* TODO: Operator:
//            + - * [/ %]
//         */
//        int a = 10;
//        int b = 3;
////        10 : 3 = nguyen 3 du 1
//        System.out.println(a + b); // 13
//        System.out.println(a - b); // 7
//        System.out.println(a * b); // 30
//        // divide: chia lay phan nguyen (/)
//        System.out.println(a / b);
//        // 31 : 4 = 7 dư 3
//        System.out.println(31 / 4); // 7
//
//
//        // module: chia lay phan du (%)
//        System.out.println(a % b);
//        System.out.println(31 % 4); // 3

//        String name = "Hello";
//        System.out.println(name); // "sout"
//
//        String hehe = "Alexander Abramov";
//        System.out.println(hehe);
//        int a = 74;
//        int b = 36;
//        System.out.println(a + b);
        // Output:

        // Input:
        // Tao ra 1 object tu class Scanner
//       **B1** Scanner scanner = new Scanner(System.in);
//
//      B2:  int number = scanner.nextInt();
//        double score = scanner.nextDouble();
//        boolean isCheck = scanner.nextBoolean();
//        String name = scanner.nextLine(); // input String "hello"
//        char x = scanner.nextLine().charAt(0); // 1 ky tu
        //        System.out.println(number);
        //
        /*
        TODO:
        6. Circle: Area and Perimeter
        Write a Java program to print the area and perimeter of a circle.
        Test Data:
        Radius = 7.5
        Expected Output
        Perimeter is = 47.12388980384689
        Area is = 176.71458676442586
         */
        Scanner scanner = new Scanner(System.in); // 1 lan duy nhat
        // 'c'amelCase -> 'r'adius
        double radius = scanner.nextDouble();
        System.out.println("Perimeter = " + 2 * Math.PI * radius);
        // Math.PI
        //
        System.out.println("Area is = " + radius * radius * Math.PI);
    }

//    System.out.println("Xin chào");
}
