package Deadlocks.Deadlockprevention.trylock.Lion.Bank;

 class NormalAccount extends Account {
     private static final long serialVersionUID = 1L;

     public NormalAccount(String accountNumber, Customer owner, double initialBalance) {
         super(accountNumber, owner, initialBalance);
     }

     @Override
     public boolean withdraw(double amount) {
         if (amount <= 0) {
             System.out.println("❌ Withdrawal amount must be greater than zero.");
             return false;
         }
         if (amount > balance) {
             System.out.println("❌ Insufficient funds. Available balance: KES " + String.format("%.2f", balance));
             return false;
         }
         balance -= amount;
         System.out.printf("✅ Withdrew KES %.2f. New Balance: KES %.2f%n", amount, balance);
         return true;
     }

     @Override
     public String getAccountType() {
         return "Normal Account";
     }
 }
