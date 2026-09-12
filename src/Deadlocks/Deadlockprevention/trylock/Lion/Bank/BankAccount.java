package Deadlocks.Deadlockprevention.trylock.Lion.Bank;

import java.io.Serializable;

public abstract class BankAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    private String accountNumber;
    private Customer owner;
    protected double balance;

    public BankAccount(String accountNumber, Customer owner, double initialBalance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Deposit amount must be greater than zero.");
            return;
        }
        balance += amount;
        System.out.printf("✅ Deposited KES %.2f. New Balance: KES %.2f%n", amount, balance);
    }

    public abstract boolean withdraw(double amount);

    public abstract String getAccountType();

    @Override
    public String toString() {
        return String.format("Acc No: %s | Owner: %s | Type: %s | Balance: KES %.2f",
                accountNumber, owner.getName(), getAccountType(), balance);
    }
}
