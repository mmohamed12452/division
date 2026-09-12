import java.io.*;

public class Erroring {

// Question 3: Banking Transaction System

    // Custom Exception for Insufficient Funds
    static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }

    // Custom Exception for Negative Amount
    static class NegativeAmountException extends Exception {
        public NegativeAmountException(String message) {
            super(message);
        }
    }

    // BankAccount Class
    static class BankAccount {
        private String accountNumber;
        private double balance;

        public BankAccount(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        // Deposit Method
        public void deposit(double amount) throws NegativeAmountException {
            if (amount < 0) {
                throw new NegativeAmountException(
                        "Cannot deposit/withdraw negative amount!");
            }

            balance += amount;
            System.out.println("Depositing ₹" + (int) amount +
                    "... New balance: ₹" + (int) balance);
        }

        // Withdraw Method
        public void withdraw(double amount)
                throws InsufficientFundsException, NegativeAmountException {

            if (amount < 0) {
                throw new NegativeAmountException(
                        "Cannot deposit/withdraw negative amount!");
            }

            if (amount > balance) {
                throw new InsufficientFundsException(
                        "Insufficient funds! Available: ₹" + (int) balance);
            }

            balance -= amount;
            System.out.println("Withdrawing ₹" + (int) amount +
                    "... New balance: ₹" + (int) balance);
        }

        // Save to File
        public void saveToFile(String filename) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
                writer.println(accountNumber);
                writer.println(balance);
                System.out.println("Saving account to file...");
            } catch (IOException e) {
                System.out.println("File Error: " + e.getMessage());
            }
        }

        // Load from File
        public static BankAccount loadFromFile(String filename) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

                String accNo = reader.readLine();
                double bal = Double.parseDouble(reader.readLine());

                System.out.println("Loading account from file...");
                return new BankAccount(accNo, bal);

            } catch (IOException e) {
                System.out.println("File Error: " + e.getMessage());
            }
            return null;
        }

        @Override
        public String toString() {
            return "A/C " + accountNumber + ", Balance: ₹" + (int) balance;
        }
    }

    // Main Method
    public static void main(String[] args) {

        BankAccount account = new BankAccount("12345", 10000);

        System.out.println("Account created: " + account);

        try {
            account.deposit(5000);
        } catch (NegativeAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("Withdrawing ₹20000...");
            account.withdraw(20000);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NegativeAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("Withdrawing ₹-1000...");
            account.withdraw(-1000);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NegativeAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }

        account.saveToFile("account.txt");

        BankAccount loadedAccount = BankAccount.loadFromFile("account.txt");

        if (loadedAccount != null) {
            System.out.println("Loaded: " + loadedAccount);
        }
    }
}
