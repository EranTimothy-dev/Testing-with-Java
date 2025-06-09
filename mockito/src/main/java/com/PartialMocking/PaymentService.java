package com.PartialMocking;

public class PaymentService {
    private AccountService accountService;

    public PaymentService(AccountService accountService) {
        this.accountService = accountService;
    }

    public boolean processPayment(String accountId, double amount) {
        double balance = accountService.getBalance(accountId);
        if (balance >= amount) {
            accountService.debit(accountId, amount);
            return true;
        }
        return false;
    }
}
