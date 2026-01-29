import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DivisionProgram  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer a = null;
        Integer b = null;

        try {
            // --- Read first integer (with retries) ---
            while (a == null) {
                System.out.print("Enter the first integer: ");
                String line = sc.nextLine();
                try {
                    a = Integer.parseInt(line.trim());
                } catch (NumberFormatException e) {
                    System.out.println("Not a valid integer. Try again.");
                }
            }

            // --- Read second integer (with retries), handle divide-by-zero later ---
            while (b == null) {
                System.out.print("Enter the second integer: ");
                String line = sc.nextLine();
                try {
                    b = Integer.parseInt(line.trim());
                } catch (NumberFormatException e) {
                    System.out.println("Not a valid integer. Try again.");
                }
            }

            // --- Compute division; handle divide-by-zero cleanly ---
            int result;
            while (true) {
                try {
                    result = a / b; // may throw ArithmeticException
                    break;          // success, exit the loop
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero. Please enter a NON-zero second integer:");
                    // re-prompt ONLY for b
                    while (true) {
                        try {
                            b = Integer.parseInt(sc.nextLine().trim());
                            break;
                        } catch (NumberFormatException nfe) {
                            System.out.println("Not a valid integer. Try again:");
                        }
                    }
                }
            }

            System.out.println(a + " / " + b + " = " + result);

            // --- Write to file in its own try block ---
            try (FileWriter fw = new FileWriter("result.txt")) {
                fw.write(a + " / " + b + " = " + result + System.lineSeparator());
                System.out.println("Saved to result.txt");
            } catch (IOException ioe) {
                System.out.println("Could not write to file: " + ioe.getMessage());
            }
        }
        finally {
            // finally runs whether exceptions happened or not
            // (Scanner doesn't strictly require closing for System.in, but do it to practice.)
            sc.close();
        }
    }
}
