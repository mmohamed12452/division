package Caring.Payments;

import java.util.Scanner;

public class SchoolPaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PaymentMethod[] methods = {
                new BankTransferPayment("SCH12345"),
                new CashPayment(),
                new CardPayment()
        };

        System.out.println("Choose Payment Method:");
        System.out.println("1. Bank Transfer");
        System.out.println("2. Cash");
        System.out.println("3. Card");

        // 2
        // enter amount: 2000
        // accepting payment
        // cash payment receipt
        // amount paid: 2000

        int choice = scanner.nextInt();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        PaymentMethod selectedMethod = methods[choice - 1];

        if (selectedMethod.validatePayment(amount)) {
            selectedMethod.pay(amount);
            selectedMethod.generateReceipt();

        } else {
            System.out.println("Payment validation failed.");
        }

        scanner.close();
    }
}
