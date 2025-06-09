package com.capturemultiplearguments;

import java.sql.Timestamp;

public class UserService {
    private NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void registerUser(String username, String email) {
        notificationService.send("Welcome " + username, email, new Timestamp(System.currentTimeMillis()));
    }
}
