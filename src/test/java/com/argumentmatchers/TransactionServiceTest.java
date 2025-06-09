package com.argumentmatchers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith({MockitoExtension.class})
public class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private LoggerService loggerService;

    @Test
    void processTransactionTest() {
        Transaction transaction = new Transaction("TX123", 10.23);

        transactionService.processTransaction(transaction);

        // verifying arguments with matchers, for objects that need multiple complex arguments
        verify(loggerService).logMessage(eq("TX123"), eq(10.23), any(Timestamp.class));
    }
}
