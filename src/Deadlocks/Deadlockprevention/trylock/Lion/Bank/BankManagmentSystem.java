package Deadlocks.Deadlockprevention.trylock.Lion.Bank;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankManagmentSystem {
    private static final String DATA_FILE = "bank_data.ser";
    private static List<Customer> customers = new ArrayList<>();
    private static List<Account> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Load persistent data from file if available
        loadData();

        while (true) {
            System.out.println("\n==========================================");
            System.out.println("          BANK MANAGEMENT SYSTEM          ");
            System.out.println("==========================================");
            System.out.println("1) Create customer only");
            System.out.println("2) View existing customers only");
            System.out.println("3) Create customer account");
            System.out.println("4) View existing accounts as a list");
            System.out.println("5) Deposit in customer account");
            System.out.println("6) Withdraw in customer account");
            System.out.println("7) View account balance");
            System.out.println("8) Exit");
            System.out.print("Select an option (1-8): ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    createCustomer();
                    break;
                case 2:
                    viewCustomers();
                    break;
                case 3:
                    createAccount();
                    break;
                case 4:
                    viewAccounts();
                    break;
                case 5:
                    depositMoney();
                    break;
                case 6:
                    withdrawMoney();
                    break;
                case 7:
                    viewAccountBalance();
                    break;
                case 8:
                    saveData();
                    System.out.println("Thank you for using Bank Management System. Goodbye!");
                    return;
                default:
                    System.out.println("❌ Invalid option. Please select 1 through 8.");
            }
        }
    }

    // ------------------------------------------
    // PERSISTENCE METHODS (SAVING & LOADING DATA)
    // ------------------------------------------

    @SuppressWarnings("unchecked")
    private static void loadData() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            // Pre-populate mock data only on first run if no data file exists
            Customer c1 = new Customer("C101", "John Doe");
            Customer c2 = new Customer("C102", "Jane Smith");
            customers.add(c1);
            customers.add(c2);
            saveData();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            customers = (List<Customer>) ois.readObject();
            accounts = (List<Account>) ois.readObject();
            System.out.println("📁 Data loaded successfully from disk!");
        } catch (Exception e) {
            System.out.println("⚠️ Could not load saved data. Starting fresh.");
        }
    }

    private static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(customers);
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("❌ Error saving data: " + e.getMessage());
        }
    }

    // ------------------------------------------
    // HELPER METHODS: SELECTING CUSTOMERS & ACCOUNTS
    // ------------------------------------------

    private static Customer selectCustomer() {
        if (customers.isEmpty()) {
            System.out.println("❌ No customers found. Please create a customer first.");
            return null;
        }

        System.out.println("\nSelect Customer Method:");
        System.out.println("1. Pick from list");
        System.out.println("2. Enter Customer ID");
        System.out.print("Choice: ");
        int choice = getIntInput();

        if (choice == 1) {
            viewCustomers();
            System.out.print("Enter list number (1-" + customers.size() + "): ");
            int index = getIntInput() - 1;
            if (index >= 0 && index < customers.size()) {
                return customers.get(index);
            }
            System.out.println("❌ Invalid choice.");
        } else if (choice == 2) {
            System.out.print("Enter Customer ID: ");
            String id = scanner.nextLine().trim();
            for (Customer c : customers) {
                if (c.getCustomerId().equalsIgnoreCase(id)) {
                    return c;
                }
            }
            System.out.println("❌ Customer ID not found.");
        } else {
            System.out.println("❌ Invalid selection.");
        }
        return null;
    }

    private static Account selectAccount() {
        if (accounts.isEmpty()) {
            System.out.println("❌ No accounts found. Please create an account first.");
            return null;
        }

        System.out.println("\nSelect Account Method:");
        System.out.println("1. Pick from list");
        System.out.println("2. Enter Account Number");
        System.out.print("Choice: ");
        int choice = getIntInput();

        if (choice == 1) {
            viewAccounts();
            System.out.print("Enter list number (1-" + accounts.size() + "): ");
            int index = getIntInput() - 1;
            if (index >= 0 && index < accounts.size()) {
                return accounts.get(index);
            }
            System.out.println("❌ Invalid choice.");
        } else if (choice == 2) {
            System.out.print("Enter Account Number: ");
            String accNum = scanner.nextLine().trim();
            for (Account acc : accounts) {
                if (acc.getAccountNumber().equalsIgnoreCase(accNum)) {
                    return acc;
                }
            }
            System.out.println("❌ Account Number not found.");
        } else {
            System.out.println("❌ Invalid selection.");
        }
        return null;
    }

    // ------------------------------------------
    // MENU ACTIONS
    // ------------------------------------------

    private static void createCustomer() {
        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine().trim();

        customers.add(new Customer(id, name));
        saveData(); // Auto-save changes to file
        System.out.println("✅ Customer created successfully!");
    }

    private static void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No existing customers.");
            return;
        }
        System.out.println("\n--- CUSTOMER LIST ---");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ") " + customers.get(i));
        }
    }

    private static void createAccount() {
        Customer customer = selectCustomer();
        if (customer == null) return;

        System.out.print("Enter New Account Number: ");
        String accNum = scanner.nextLine().trim();

        System.out.println("Select Account Type:");
        System.out.println("1. Normal Account");
        System.out.println("2. Savings Account (Requires min KES 1,000 reserve)");
        System.out.print("Choice: ");
        int type = getIntInput();

        System.out.print("Enter Initial Deposit (KES): ");
        double initialBalance = getDoubleInput();

        if (type == 2 && initialBalance < 1000) {
            System.out.println("❌ Cannot create Savings Account with less than KES 1,000.");
            return;
        }

        Account newAcc;
        if (type == 2) {
            newAcc = new SavingsAccount(accNum, customer, initialBalance);
        } else if (type == 1) {
            newAcc = new NormalAccount(accNum, customer, initialBalance);
        } else {
            System.out.println("❌ Invalid account type selection.");
            return;
        }

        accounts.add(newAcc);
        saveData(); // Auto-save changes to file
        System.out.println("✅ Account created successfully!");
    }

    private static void viewAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No existing accounts.");
            return;
        }
        System.out.println("\n--- ACCOUNT LIST ---");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ") " + accounts.get(i));
        }
    }

    private static void depositMoney() {
        Account account = selectAccount();
        if (account == null) return;

        System.out.print("Enter amount to deposit (KES): ");
        double amount = getDoubleInput();
        account.deposit(amount);
        saveData(); // Auto-save changes to file
    }

    private static void withdrawMoney() {
        Account account = selectAccount();
        if (account == null) return;

        System.out.print("Enter amount to withdraw (KES): ");
        double amount = getDoubleInput();
        account.withdraw(amount);
        saveData(); // Auto-save changes to file
    }

    private static void viewAccountBalance() {
        Account account = selectAccount();
        if (account == null) return;

        System.out.println("\n==========================================");
        System.out.println("            ACCOUNT BALANCE               ");
        System.out.println("==========================================");
        System.out.println("Account Number : " + account.getAccountNumber());
        System.out.println("Owner          : " + account.getOwner().getName());
        System.out.println("Type           : " + account.getClass().getSimpleName());
        System.out.println("Balance        : KES " + account.getBalance());
        System.out.println("==========================================");
    }

    // Input safety utilities
    private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static double getDoubleInput() {
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
