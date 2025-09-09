package Review.file2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HINHCHUNHAT {
    public static void main(String[] args) {
        File inputFile = new File("src/Review.file2/chieudai&rong");
        File result = new File("src/Review.file2/result");
        try (
                Scanner scan = new Scanner(inputFile);
                FileWriter fw = new FileWriter(result, true);
        ) {
            while (scan.hasNext()) {
                try {
                    if (!scan.hasNextInt()) {
                        throw new InvalidInputException("error datatype");
                    }
                    int num1 = scan.nextInt();
                    if (!scan.hasNextInt()) {
                        throw new InvalidInputException("error datatype #2");
                    }
                    int num2 = scan.nextInt();
                    fw.write("DIEN TICH: " + num1 * num2);

                } catch (InvalidInputException e) {
                    System.err.println("Invalid Input:" + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
