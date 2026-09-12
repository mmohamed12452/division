package Deadlocks.Deadlockprevention.trylock.Lion.Bank;

public class SavingsAccount extends BankAccount{
    private static final long serialVersionUID = 1L;
    private static final double MINIMUM_BALANCE = 1000.00;

    public SavingsAccount(String accountNumber, Customer owner, double initialBalance) {
        super(accountNumber, owner, initialBalance);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Withdrawal amount must be greater than zero.");
            return false;
        }
        if ((balance - amount) < MINIMUM_BALANCE) {
            System.out.printf("❌ Withdrawal denied! Savings account must retain at least KES %.2f.%n", MINIMUM_BALANCE);
            System.out.printf("   Current Balance: KES %.2f | Max Withdrawable: KES %.2f%n",
                    balance, Math.max(0, balance - MINIMUM_BALANCE));
            return false;
        }
        balance -= amount;
        System.out.printf("✅ Withdrew KES %.2f. New Balance: KES %.2f%n", amount, balance);
        return true;
    }

    @Override
    public String getAccountType() {
        return "Savings Account";
    }
}
