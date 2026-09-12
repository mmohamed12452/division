package Deadlocks.Deadlockprevention.trylock.Lion.Bank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    private static final String CUSTOMERS_FILE = "customers.dat";
    private static final String ACCOUNTS_FILE = "accounts.dat";

    @SuppressWarnings("unchecked")
    public static List<Customer> loadCustomers() {
        File file = new File(CUSTOMERS_FILE);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Customer>) ois.readObject();
        } catch (Exception e) {
            System.out.println("⚠️ Warning: Could not load customer records.");
            return new ArrayList<>();
        }
    }

    public static void saveCustomers(List<Customer> customers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CUSTOMERS_FILE))) {
            oos.writeObject(customers);
        } catch (IOException e) {
            System.out.println("❌ Error saving customers: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<BankAccount> loadAccounts() {
        File file = new File(ACCOUNTS_FILE);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<BankAccount>) ois.readObject();
        } catch (Exception e) {
            System.out.println("⚠️ Warning: Could not load account records.");
            return new ArrayList<>();
        }
    }

    public static void saveAccounts(List<BankAccount> accounts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ACCOUNTS_FILE))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("❌ Error saving accounts: " + e.getMessage());
        }
    }
}
