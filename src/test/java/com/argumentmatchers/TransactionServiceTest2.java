package com.argumentmatchers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest2 {
    @InjectMocks
    private TransactionService underTest;

    @Mock
    private LoggerService loggerService;

    @Captor
    private ArgumentCaptor<Timestamp> timestampCaptor;

    @Test
    public void processTransaction() {
        Timestamp start = new Timestamp(System.currentTimeMillis());

        Transaction transaction = new Transaction("TX123", 10.50);
        underTest.processTransaction(transaction);

        verify(loggerService).logMessage(eq("TX123"), eq(10.50),
                timestampCaptor.capture());

        Timestamp resultTimestamp = timestampCaptor.getValue();
        System.out.println("Timestamp " + resultTimestamp);
        assertTrue(areWithinSeconds(start, resultTimestamp, 5));
    }

    private boolean areWithinSeconds(Timestamp timestamp1, Timestamp timestamp2, int seconds) {
        long differenceInMillis = Math.abs(timestamp1.getTime() - timestamp2.getTime());
        long differenceInSeconds = differenceInMillis / 1000;
        return differenceInSeconds <= seconds;
    }
}
