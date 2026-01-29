import java.util.InputMismatchException;
import java.util.Scanner;

public class Loony {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a integer ");
//
//        int int1 = scanner.nextInt();
//        System.out.println("The next integer is " + int1);

        // Ask for the user input
        System.out.println("Please enter an integer:");

        int int2 = 0;  // initializing the variable to hold user input
        boolean validInput = false;  // flag to track if input is valid

        while (!validInput) {
            try {
                int2 = scanner.nextInt();  // Attempt to read an integer
                validInput = true;  // If no exception occurs, input is valid
            } catch (InputMismatchException e) {
                // If the input is not an integer, print an error message
                System.out.println("This is the wrong input: please enter an integer.");

                // Clear the invalid input from the scanner
                scanner.nextLine();  // Consume the rest of the invalid input
            }
        }

        // Once a valid integer is entered, proceed
        System.out.println("You have entered an integer, well done!");
        System.out.println("The entered integer is: " + int2);
    }
}
