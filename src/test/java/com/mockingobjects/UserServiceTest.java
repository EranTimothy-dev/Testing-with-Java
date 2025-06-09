package com.mockingobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {



    @Test
    public void findByUserId() {
        // mocking allows us to test the logic removing any database dependencies
        UserRepository userRepositoryMock = mock(UserRepository.class);

        User mockUser = new User("1", "John Doe");
        when(userRepositoryMock.findById("1")).thenReturn(mockUser);

        UserService underTest = new UserService(userRepositoryMock);

        User result = underTest.findUserById("1");

        assertEquals(mockUser, result);
        verify(userRepositoryMock).findById("1"); // verify that the test is happening as expected
    }
}
