package JavaThreads.RaceCondition;

class BankAccount {
    private int balance = 1000;

    public void withdraw(int amount, String threadName) {
        if (balance >= amount) {
            // Force race condition with sleep
            try { Thread.sleep(10); } catch (InterruptedException e) {}

            balance = balance - amount;
        }
    }
    public int getBalance() { return balance; }
    public void setBalance(int balance) { this.balance = balance; }
}
