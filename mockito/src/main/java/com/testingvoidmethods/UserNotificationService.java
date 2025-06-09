package com.testingvoidmethods;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UserNotificationService {
    private final EmailService emailService;
    private final Logger logger;

    public UserNotificationService(EmailService emailService, Logger logger) {
        this.emailService = emailService;
        this.logger = logger;
    }

    public void notifyUser(String email, String message) {
        try {
            logger.info("Attempting to send notification to " + email);
            emailService.sendEmail(email, "Notification", message);
            logger.info("Notification sent to " + email);
        } catch (EmailException e) {
            logger.log(Level.SEVERE, "Failed to send email to " + email, e);
        }
    }
}
