package B1.Lecture;

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        // Nhập cạnh đáy , chiều cao => Tính diện tích tam giác
        // input baseCase, height => area
        Scanner scanner = new Scanner(System.in);
        double height = scanner.nextDouble();
        double baseCase = scanner.nextDouble();
        System.out.println((double) 1 / 2 * baseCase * height);
    }
}
