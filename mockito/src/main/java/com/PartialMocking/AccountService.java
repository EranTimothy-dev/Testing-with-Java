package com.PartialMocking;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private Map<String, Double> accounts = new HashMap<>();

    public AccountService() {
        accounts.put("account1", 1000.0);
        accounts.put("account2", 500.0);
    }

    public double getBalance(String accountId) {
        return accounts.getOrDefault(accountId, 0.0);
    }

    public void debit(String accountId, double amount) {
        double currentBalance = getBalance(accountId);
        accounts.put(accountId, currentBalance - amount);
    }
}
