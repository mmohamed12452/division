package Caring.Payment;

class CashPayments extends PaymentMethods {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " in cash.");
    }
}
