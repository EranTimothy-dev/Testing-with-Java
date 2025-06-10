package com.testingspringbootapplication.testingspringrepositories;

import com.testingspringbootapplication.springrepositories.User;
import com.testingspringbootapplication.springrepositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@DataJpaTest
public class UserRepositoryTest {


    private final User USER = new User("John Doe", "john@doe.com");

    @Autowired
    private UserRepository underTest;

    @Test
    void saveUser() {
        User savedUser = underTest.save(USER);
        assertEquals(USER, savedUser);
    }

    @Test
    void findById() {
        User savedUser = underTest.save(USER);
        User foundUser = underTest.findById(savedUser.getId()).orElse(null);
        assertEquals(savedUser, foundUser);
    }


}
