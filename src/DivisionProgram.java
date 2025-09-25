import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionProgram {
    public static void main(String[] args) {
        int num1;
        int num2;
        Integer result;


        try (Scanner scanner = new Scanner(System.in)) {
            // Get first number
            while (true) {
                System.out.print("Enter the first whole number: ");
                try {
                    num1 = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("That's not a valid whole number. Try again.");
                    scanner.nextLine(); // clear the invalid input
                }
            }

            // entering the second number
            while (true) {
                System.out.print("Enter the second whole number (not zero): ");
                try {
                    num2 = scanner.nextInt();
                    if (num2 == 0) {
                        System.out.println("Cannot divide by zero. Try again.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("That's not a valid whole number. Try again.");
                    scanner.nextLine(); // clear the invalid input
                }
            }


            result = (Integer) num1 / num2;
            System.out.println("Result: " + result);

            // Save result to file using try-with-resources
            try (FileWriter writer = new FileWriter("result.txt")) {
                writer.write("Result: " + result);
                System.out.println("Result saved to result.txt");
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }

        } // scanner is automatically closed here
    }
}
