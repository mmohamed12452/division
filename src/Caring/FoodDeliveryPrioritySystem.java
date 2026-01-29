package Caring;

import java.util.Scanner;

public class FoodDeliveryPrioritySystem
{
    public static void main(String[] args) {
        // Create scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Input the distance, order value, and VIP status
        System.out.print("Enter the distance to the customer (in km): ");
        double distance = scanner.nextDouble();

        System.out.print("Enter the order value (in dollars): ");
        double orderValue = scanner.nextDouble();

        System.out.print("Is the customer a VIP? (yes/no): ");
        String vipStatus = scanner.next().toLowerCase();

        // Determine the priority
        String priority = "";

        if (vipStatus.equals("yes")) { // VIP customer
            if (distance <= 3) {
                if (orderValue >= 50) {
                    priority = "CRITICAL";
                } else {
                    priority = "HIGH";
                }
            } else { // distance > 3 km
                if (orderValue >= 50) {
                    priority = "HIGH";
                } else {
                    priority = "MEDIUM";
                }
            }
        } else { // Non-VIP customer
            if (distance <= 3) {
                if (orderValue >= 50) {
                    priority = "HIGH";
                } else {
                    priority = "MEDIUM";
                }
            } else { // distance > 3 km
                if (orderValue >= 50) {
                    priority = "MEDIUM";
                } else {
                    priority = "LOW";
                }
            }
        }

        // Output the priority
        System.out.println("Priority: " + priority);

        // Close the scanner to prevent data leaks
        scanner.close();
    }

    // Enter the distance to the customer in (km):
    // 4
    // Enter the order value (in dollars):
    //5
    // is customer vip or not (yes or no):
    // yes

    // priorioty high

}
