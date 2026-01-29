package Caring;

public class BackAccounting {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("4688999", "Alex", 400.0);
        account.deposit(200);
        account.withdraw(100);
        account.withdraw(700);
        account.deposit(-50);

        System.out.println("Final balance: " + account.getBalance());
    }
}
