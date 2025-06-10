package com.testingspringbootapplication.testingspringrepositories;

import com.testingspringbootapplication.springrepositories.User;
import com.testingspringbootapplication.springrepositories.UserRepository;
import com.testingspringbootapplication.springrepositories.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private final User USER = new User("John Doe", "john.doe@example.com");

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService underTest;

    @Test
    void saveUserTest() {
        when(userRepository.save(USER)).thenReturn(USER);

        User savedUser = underTest.saveUser(USER);

        assertEquals(USER, savedUser);
        verify(userRepository).save(USER);
    }

    @Test
    void  findByIdTest() {
        when(userRepository.findById(USER.getId())).thenReturn(Optional.of(USER));

        Optional<User> foundUser = underTest.getUserById(USER.getId());

        assertTrue(foundUser.isPresent());
        assertEquals(USER, foundUser.get());
        verify(userRepository).findById(USER.getId());
    }
}
