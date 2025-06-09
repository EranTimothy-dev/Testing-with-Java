package com.testingvoidmethods;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

public class UserNotificationServiceTest {

    @Mock
    private EmailService emailService;

    @Mock
    private Logger logger;

    @InjectMocks
    private UserNotificationService underTest;

    private static final String EMAIL = "test@example.com";
    private static final String MESSAGE = "Hello, User!";

    @Test
    void notifyUsers() throws EmailException {
        underTest.notifyUser(EMAIL, MESSAGE);

        verify(emailService).sendEmail(EMAIL, "Notification", MESSAGE);
        verify(logger).info("Attempting to send notification to " + EMAIL);
        verify(logger).info("Notification sent to " + EMAIL);
    }

    @Test
    void notifyUser_EmailException() throws EmailException {
        doThrow(new EmailException("Email sending failed"))
                .when(emailService).sendEmail(EMAIL, "Notification", MESSAGE);

        // the when and thenThrow cannot be used on void methods.
        // when(emailService.sendEmail(EMAIL, "Notification", MESSAGE))
        // .thenThrow(new EmailException("Email sending failed"));

        underTest.notifyUser(EMAIL, MESSAGE);
        verify(emailService).sendEmail(EMAIL, "Notification", MESSAGE);
        verify(logger).info("Attempting to send notification to " + EMAIL);
        verify(logger).log(eq(Level.SEVERE), eq("Failed to send email to " + EMAIL),
                any(EmailException.class));

    }
}
