package Deadlocks.Deadlockprevention.trylock.Lion.Bank;

import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Customer> customers;
    static List<BankAccount> accounts;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Load stored data from disk
        customers = DataStorage.loadCustomers();
        accounts = DataStorage.loadAccounts();

        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Select an option (1-7): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    createCustomer();
                    break;
                case "2":
                    viewCustomers();
                    break;
                case "3":
                    createAccount();
                    break;
                case "4":
                    viewAccounts();
                    break;
                case "5":
                    depositMoney();
                    break;
                case "6":
                    withdrawMoney();
                    break;
                case "7":
                    DataStorage.saveCustomers(customers);
                    DataStorage.saveAccounts(accounts);
                    System.out.println("\n✅ All data saved successfully. Application terminated.");
                    running = false;
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please select an option between 1 and 7.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("==========================================");
        System.out.println("          BANK MANAGEMENT SYSTEM          ");
        System.out.println("==========================================");
        System.out.println("1) Create customer only");
        System.out.println("2) View existing customers only");
        System.out.println("3) Create customer accounts");
        System.out.println("4) View existing accounts as a list");
        System.out.println("5) Deposit in customer account");
        System.out.println("6) Withdraw in customer account");
        System.out.println("7) Exit");
        System.out.println("==========================================");
    }

    private static void createCustomer() {
        System.out.println("\n--- Create Customer ---");
        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine().trim();

        if (findCustomerById(id) != null) {
            System.out.println("❌ A customer with ID '" + id + "' already exists.");
            return;
        }

        System.out.print("Enter Customer Full Name: ");
        String name = scanner.nextLine().trim();

        customers.add(new Customer(id, name));
        DataStorage.saveCustomers(customers);
        System.out.println("✅ Customer registered and saved!");
    }

    private static void viewCustomers() {
        System.out.println("\n--- Registered Customers ---");
        if (customers.isEmpty()) {
            System.out.println("No registered customers found.");
            return;
        }
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i));
        }
    }

    private static void createAccount() {
        System.out.println("\n--- Create Customer Account ---");
        if (customers.isEmpty()) {
            System.out.println("❌ No customers registered. Please create a customer first (Option 1).");
            return;
        }

        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine().trim();
        Customer owner = findCustomerById(id);

        if (owner == null) {
            System.out.println("❌ Customer ID not found.");
            return;
        }

        System.out.print("Enter New Account Number: ");
        String accNum = scanner.nextLine().trim();

        if (findAccountByNumber(accNum) != null) {
            System.out.println("❌ Account number already exists.");
            return;
        }

        System.out.println("Select Account Type:");
        System.out.println("  1. Normal Account");
        System.out.println("  2. Savings Account (Minimum Balance required: KES 1,000)");
        System.out.print("Choice: ");
        String typeChoice = scanner.nextLine().trim();

        System.out.print("Enter Initial Deposit (KES): ");
        double initialBalance;
        try {
            initialBalance = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid amount format.");
            return;
        }

        BankAccount newAccount;
        if (typeChoice.equals("1")) {
            if (initialBalance < 0) {
                System.out.println("❌ Initial deposit cannot be negative.");
                return;
            }
            newAccount = new NormalAccount(accNum, owner, initialBalance);
        } else if (typeChoice.equals("2")) {
            if (initialBalance < 1000) {
                System.out.println("❌ Savings account requires an initial balance of at least KES 1,000.");
                return;
            }
            newAccount = new SavingsAccount(accNum, owner, initialBalance);
        } else {
            System.out.println("❌ Invalid account type choice.");
            return;
        }

        accounts.add(newAccount);
        DataStorage.saveAccounts(accounts);
        System.out.println("✅ Account created and saved successfully for " + owner.getName() + "!");
    }

    private static void viewAccounts() {
        System.out.println("\n--- Registered Accounts ---");
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". " + accounts.get(i));
        }
    }

    private static void depositMoney() {
        System.out.println("\n--- Deposit Funds ---");
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine().trim();

        BankAccount account = findAccountByNumber(accNum);
        if (account == null) {
            System.out.println("❌ Account not found.");
            return;
        }

        System.out.print("Enter Deposit Amount (KES): ");
        try {
            double amount = Double.parseDouble(scanner.nextLine().trim());
            account.deposit(amount);
            DataStorage.saveAccounts(accounts);
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid numeric input.");
        }
    }

    private static void withdrawMoney() {
        System.out.println("\n--- Withdraw Funds ---");
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine().trim();

        BankAccount account = findAccountByNumber(accNum);
        if (account == null) {
            System.out.println("❌ Account not found.");
            return;
        }

        System.out.print("Enter Withdrawal Amount (KES): ");
        try {
            double amount = Double.parseDouble(scanner.nextLine().trim());
            if (account.withdraw(amount)) {
                DataStorage.saveAccounts(accounts);
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid numeric input.");
        }
    }

    private static Customer findCustomerById(String id) {
        for (Customer c : customers) {
            if (c.getCustomerId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    private static BankAccount findAccountByNumber(String accNum) {
        for (BankAccount a : accounts) {
            if (a.getAccountNumber().equalsIgnoreCase(accNum)) {
                return a;
            }
        }
        return null;
    }
}
