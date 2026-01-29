package Caring;

import java.util.Scanner;

public class LongestStreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int longstreak = 0;
        int currentstreak = 0;

        while (true) {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();

            // Stop the loop if 0 is entered
            if (num == 0) {
                break;
            }

            // If the number is positive, increase the current streak
            if (num > 0) {
                currentstreak++;
                // Update the longest streak if the current streak is longer
                if (currentstreak > longstreak) {
                    longstreak = currentstreak;
                }
            } else {
                // Reset the streak if a non-positive number is entered
                currentstreak = 0;
            }
        }

        // Output the longest streak of positive numbers
        System.out.println("The longest streak of positive numbers is: " + longstreak);

        scanner.close();
    }
}
