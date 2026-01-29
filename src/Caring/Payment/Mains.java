package Caring.Payment;

public class Mains {
    public static void main(String[] args) {
        double amount = 9000;
        PaymentMethods[] payments = new PaymentMethods[2];
        payments[0] = new CardPayments();
        payments[1] = new CashPayments();

        for(PaymentMethods payment : payments){
            payment.pay(amount);
        }
    }
}
