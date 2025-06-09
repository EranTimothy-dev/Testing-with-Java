package com.verifymultipleinteractionstest;

import com.verifymultipleinteractions.UserRepository;
import com.verifymultipleinteractions.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService underTest;

    @Mock
    private UserRepository userRepository;

    private static final String USERNAME_1 = "Alice";
    private static final String USERNAME_2 = "Bob";

    @Test
    public void createUser() {

        underTest.createUser(USERNAME_1);
        verify(userRepository).save(USERNAME_1);

        verify(userRepository, never()).delete(anyString()); // verify that delete method is never called for create user test
    }

    @Test
    void createMultipleUsers() {
        underTest.createUser(USERNAME_1);
        underTest.createUser(USERNAME_2);

        verify(userRepository, times(2)).save(anyString());
    }
}
