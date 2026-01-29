package Caring.Payments;

public class CardPayment extends PaymentMethod {

    @Override
    boolean validatePayment(double amount) {
        return amount >= 500;
    }

    @Override
    public void pay(double amount) {
        double amount1 = amount;
        System.out.println("Processing card payment...");
    }

    @Override
   public void generateReceipt() {
        System.out.println("Card Payment Receipt");
        System.out.println("Amount Paid: $");
    }
}
