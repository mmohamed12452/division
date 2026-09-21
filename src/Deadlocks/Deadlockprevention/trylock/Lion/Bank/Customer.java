package Deadlocks.Deadlockprevention.trylock.Lion.Bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    private String customerId;
    private String name;
    private List<Account> accounts;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccount(String accountNumber)
    {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    // Overriding toString() prevents printing memory locations like @2dda6444
    @Override
    public String toString() {
        return "ID: " + customerId + " | Name: " + name;
    }
}
