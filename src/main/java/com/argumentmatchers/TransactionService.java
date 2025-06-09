package com.argumentmatchers;

import java.sql.Timestamp;

public class TransactionService {
    private LoggerService loggerService;

    public TransactionService(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    public void processTransaction(Transaction transaction) {
        // Process the transaction (implementation not shown)
        // Log the transaction
        loggerService.logMessage(transaction.getTransactionId(), transaction.getAmount(),
                new Timestamp(System.currentTimeMillis()));
    }
}
