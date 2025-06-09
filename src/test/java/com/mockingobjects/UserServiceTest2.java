package com.mockingobjects;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest2 {

    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private UserService underTest; // make mockito handle injecting required mock objects, can only be used with classes

    @Test
    public void findByUserId() {

        User mockUser = new User("1", "John Doe");
        when(userRepositoryMock.findById("1")).thenReturn(mockUser);

        User result = underTest.findUserById("1");

        assertEquals(mockUser, result);
        verify(userRepositoryMock).findById("1"); // verify that the test was called
    }

    @Test
    void findUserByIdNonExistingUser() {
        when(userRepositoryMock.findById("2")).thenReturn(null); // this is known as stubbing
        assertNull(underTest.findUserById("2"));
        verify(userRepositoryMock).findById("2");
    }

}
