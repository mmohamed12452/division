package Caring.Payments;

class BankTransferPayment extends PaymentMethod {
    private String referenceNumber;
    private double lastAmount;

    BankTransferPayment(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    @Override
    boolean validatePayment(double amount) {
        return amount > 0 && referenceNumber != null && !referenceNumber.isEmpty();
    }

    @Override
    void pay(double amount) {
        lastAmount = amount;
        System.out.println("Processing bank transfer...");
    }

    @Override
    void generateReceipt() {
        System.out.println("Bank Transfer Receipt");
        System.out.println("Reference: " + referenceNumber);
        System.out.println("Amount Paid: $" + lastAmount);
    }
}
