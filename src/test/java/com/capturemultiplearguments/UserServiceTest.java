package com.capturemultiplearguments;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private UserService underTest;

    @Captor
    private ArgumentCaptor<Timestamp> timestampCaptor;

    @Test
    public void registerUser() {
        String username = "john_doe";
        String email = "john@example.com";

        underTest.registerUser(username, email);

        verify(notificationService).send(eq("Welcome " + username),
                eq(email), timestampCaptor.capture());

        assertTrue(areWithinSeconds(new Timestamp(System.currentTimeMillis()),
                timestampCaptor.getValue(), 2));
    }

    @Test
    public void registerMultipleUsers() {
        List<String> usernames = List.of("john_doe", "jane_smith", "alice_wonderland");
        List<String> emails = List.of("john@example.com", "jane@example.com", "alice@example.com");

        for (int i = 0; i < usernames.size(); i++){
            underTest.registerUser(usernames.get(i), emails.get(i));
            verify(notificationService).send(eq("Welcome " + usernames.get(i)),
                    eq(emails.get(i)), timestampCaptor.capture());
        }

        List<Timestamp> captureTimeStamps = timestampCaptor.getAllValues();
        for (Timestamp t : captureTimeStamps) {
            assertTrue(areWithinSeconds(new Timestamp(System.currentTimeMillis()),t, 2));
        }
    }

    private boolean areWithinSeconds(Timestamp timestamp1, Timestamp timestamp2, int seconds) {
        long differenceInMillis = Math.abs(timestamp1.getTime() - timestamp2.getTime());
        long differenceInSeconds = differenceInMillis / 1000;
        return differenceInSeconds <= seconds;
    }
}
