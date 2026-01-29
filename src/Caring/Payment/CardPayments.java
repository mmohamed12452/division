package Caring.Payment;

 class CardPayments extends PaymentMethods{
     @Override
     public void pay(double amount) {
         if(amount > 5000){
             System.out.println("Paid " + amount + " by card. PIN required.");
         }else {
             System.out.println("Paid " + amount + " by card. Tap to pay.");
         }
     }
 }
