// Define the package path where this class resides within the project directory structure.
package Deadlocks.Deadlockprevention.trylock;

// Define a public class named BankAccount, serving as a blueprint for bank account objects.
public class BankAccount {

    // --- STATE VARIABLES (FIELDS / ATTRIBUTES) ---

    // Encapsulated private instance variable to store the account holder's name.
    private String customerName;

    // Encapsulated private instance variable to hold the unique identifier for the account.
    private String accountNumber;

    // Encapsulated private double variable to hold the current balance.
    private double balance;


    // --- CONSTRUCTOR ---

    /**
     * Parameterized Constructor:
     * Initializes a new BankAccount object with the provided customer name, account number, and initial deposit.
     */
    public BankAccount(String customerName, String accountNumber, double initialBalance) {
        // Assign the passed customerName parameter to the instance variable using 'this' to avoid variable confusion.
        this.customerName = customerName;

        // Assign the passed accountNumber parameter to the instance variable.
        this.accountNumber = accountNumber;

        // Defensive initialization: Use Math.max to prevent the account from starting with a negative balance.
        // If initialBalance is negative, it defaults to 0.0.
        this.balance = Math.max(0.0, initialBalance);
    }

    // --- BEHAVIOR (METHODS) ---

    /**
     * Deposits a given amount balance into the account.
     */
    public void deposit(double amount) {
        // Input validation guard clause: Ensures the deposit amount is positive.
        if (amount <= 0) {
            System.out.println("Error: Deposit amount must be greater than $0.00.");
            return; // Terminate execution of the method early if validation fails.
        }

        // Mutate the state: Add the deposit amount to the existing balance.
        balance += amount;

        // Print a formatted success message displaying the deposited amount and updated balance.
        System.out.printf("Successfully deposited $%.2f. New Balance: $%.2f%n", amount, balance);
    }

    /**
     * Withdraws a specified amount from the account if sufficient funds exist.
     * Returns true if successful, false otherwise.
     */
    public boolean withdraw(double amount) {
        // Input validation guard clause: Prevents non-positive withdrawal attempts.
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be greater than $0.00.");
            return false; // Return false to signal that the withdrawal transaction failed.
        }

        // Business rule check: Ensures the account has enough funds to cover the withdrawal.
        if (amount > balance) {
            System.out.printf("Error: Insufficient funds. Attempted to withdraw $%.2f, but balance is $%.2f.%n", amount, balance);
            return false; // Return false due to overdraft attempt.
        }

        // Deduct the requested withdrawal amount from the current balance.
        balance -= amount;

        // Print formatted output indicating successful withdrawal and the remaining balance.
        System.out.printf("Successfully withdrew $%.2f. Remaining Balance: $%.2f%n", amount, balance);

        // Return true to indicate the transaction completed successfully.
        return true;
    }

    // --- GETTER METHODS ---

    // Getter method to provide read-only access to the private balance field.
    public double getBalance() {
        return balance;
    }

    // Getter method to retrieve the customer name.

    public String getCustomerName() {
        return customerName;
    }

    // Getter method to retrieve the account number.
    public String getAccountNumber() {
        return accountNumber;
    }

    // --- DISPLAY / UTILITY METHODS ---

    /**
     * Prints a formatted summary of the bank account details reciet to standard output.
     */
    public void displayAccountSummary() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Account Number: " + accountNumber);
        // Display current balance formatted to two decimal places.
        System.out.printf("Current Balance: $%.2f%n", balance);
        System.out.println("-----------------------\n");
    }

    // --- MAIN METHOD (EXECUTION ENTRY POINT) ---

    public static void main(String[] args) {
        // Instantiate a new BankAccount object named 'aliceAccount' with $500.00 initial balance.
        BankAccount aliceAccount = new BankAccount("Alice Smith", "ACC-10045", 500.00);

        // Invoke the summary method to output Alice's initial account configuration.
        aliceAccount.displayAccountSummary();

        // Perform a valid deposit of $150.25 (expected new balance: $650.25).
        aliceAccount.deposit(150.25);

        // Perform a valid withdrawal of $100.00 (expected remaining balance: $550.25).
        aliceAccount.withdraw(100.00);

        // Attempt an invalid withdrawal of $700.00 (triggers insufficient funds guard clause).
        aliceAccount.withdraw(700.00);

        // Fetch and print the final account balance using the getter method ($550.25 expected).
        System.out.printf("Final balance check: $%.2f%n", aliceAccount.getBalance());

    }
}