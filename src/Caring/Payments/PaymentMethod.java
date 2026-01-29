package Caring.Payments;

abstract class PaymentMethod
{
    abstract boolean validatePayment(double amount);

    abstract void pay(double amount);

    abstract void generateReceipt();

}
