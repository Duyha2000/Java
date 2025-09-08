package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileProductCalculator {
    public static void main(String[] args) throws IOException {
        // B1: Open file(input, output)
        // B2: Write (output)
        // B3: Close
        File inputFile = new File("src/file/example.txt");
        File outputFile = new File("src/file/result.txt");

        try (
                Scanner scanner = new Scanner(inputFile);
                FileWriter writer = new FileWriter(outputFile, true)) {
            while (scanner.hasNext()) {
                try {
                    if (!scanner.hasNextDouble()) {
                        throw new InvalidInputException("Invalid first number");
                    }
                    double num1 = scanner.nextDouble();

                    if (!scanner.hasNextDouble()) {
                        throw new InvalidInputException("Invalid second number");
                    }
                    double num2 = scanner.nextDouble();
                    writer.write("Product: " + (num1 * num2));
                } catch (InvalidInputException e) {
                    System.out.println("Invalid input: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("Err " + e.getMessage());
        }

    }
}
