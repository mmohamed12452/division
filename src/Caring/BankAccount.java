package Caring;

public class BankAccount
{
    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount <= 0){
            System.out.println("Deposit amount must be greater than 0");
        }
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void  withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal denied.");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
    }
    public double getBalance(){
        return balance;
    }
}
