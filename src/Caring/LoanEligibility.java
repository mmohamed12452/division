package Caring;

import java.util.Scanner;

public class LoanEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // inputs
        System.out.println("Enter the age: ");
        int age = scanner.nextInt();

        System.out.println("Enter monthly income: ");
        double income = scanner.nextDouble();

        System.out.println("Enter credit score (0-100): ");
        int creditScore = scanner.nextInt();

        if (age >= 21 && income >= 30000) {
            // Eligible, check risk tier
            if (creditScore >= 80) {
                System.out.println("Eligible: Tier 1 - Low Risk");
            } else if (creditScore >= 60) {
                System.out.println("Eligible: Tier 2 - Medium Risk");
            } else if (creditScore >= 40) {
                System.out.println("Eligible: Tier 3 - High Risk");
            } else {
                System.out.println("Eligible: Tier 4 - Very High Risk");
            }
        } else {
            System.out.println("Not eligible");
        }

        scanner.close();

    }

}
