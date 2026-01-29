import java.util.Scanner;

public class DiscountCalculator {
    public static void main(String[] args) {

        // 1) I  initialized the scanner to get the input from the user
        Scanner scanner = new Scanner(System.in);

        // 2) Ask the user to enter the purchase amount
        System.out.println("Enter the purchase amount: ");

        double amount = scanner.nextDouble(); // read the input value from the user

        // 3) decision-making: checking if the amount is greater than 10,000

        double discount;

        if(amount > 10000){
            // if the amount is greater than 10,000, I will apply the 10% discount.
            discount = 0.10;
            System.out.println("You are qualified for a 10% discount!");
        }
        else {
            // if the amount is 10,000 or less, I will apply the 5% discount
            discount = 0.05;
            System.out.println("You are qualified for a 5% discount!");
        }

        // calculate the final value
        double finalPrice = amount - (amount * discount);

        // the final price after the discount
        System.out.println("The final price after the discount is: $" + finalPrice);

        // closes the scanner import to avoid data leakage.
        scanner.close();


    }
}
