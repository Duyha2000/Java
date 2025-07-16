package B1.Lecture;

public class PrintMyAge {
    // tên function/method: gõ "main" -> tab
    public static void main(String[] args) {
        int a = 2021;
        int b = 2002;

        // hard core
        // new line: \n
//        System.out.println("I was born in " + b + "\n. This year is " + a +
//                "Therefore, my age is: \n" + (a - b));
// +: phép nối
        System.out.println("I was born in " + b + " This year is " + a);
        System.out.println("Therefore, my age is: ");
        System.out.println(a - b);
    }
}
