package Caring.Payments;

class CashPayment extends PaymentMethod {
    private double lastAmount;
    private static final double MAX_LIMIT = 9000000;

    @Override
    boolean validatePayment(double amount) {
        return amount > 0 && amount <= MAX_LIMIT;
    }

    @Override
    void pay(double amount) {
        lastAmount = amount;
        System.out.println("Accepting cash payment...");
    }

    @Override
    void generateReceipt() {
        System.out.println("Cash Payment Receipt");
        System.out.println("Amount Paid: $" + lastAmount);
    }
}
