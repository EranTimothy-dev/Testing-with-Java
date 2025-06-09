package com.partialmocking;

import com.PartialMocking.AccountService;
import com.PartialMocking.PaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class PaymentServiceTest {

    @Spy
    private AccountService accountServiceSpy; // class that is going to be partially mocked

    @InjectMocks
    private PaymentService underTest;

    @Test
    public void processPaymentWithSpy() {
        doReturn(1000.0).when(accountServiceSpy).getBalance("account1"); // mock only this service

        // when the following is called the actual getBalance isnt called instead the above stub is used. but the rest is called
        boolean result = underTest.processPayment("account1", 500.0);

        assertTrue(result);
        verify(accountServiceSpy, times(2)).getBalance("account1");
        verify(accountServiceSpy).debit("account1", 500.0);
    }

    @Test
    public void insufficientBalanceWithSpy() {
        doReturn(300.0).when(accountServiceSpy).getBalance("account2");

        boolean result = underTest.processPayment("account2", 500.0);

        assertFalse(result);
        verify(accountServiceSpy).getBalance("account2");
        verify(accountServiceSpy, never()).debit(anyString(), anyDouble());
    }
}
