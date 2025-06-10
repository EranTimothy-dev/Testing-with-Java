package com.testingspringbootapplication.testingspringrepositories;

import com.testingspringbootapplication.springrepositories.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserApplicationIT {

    @Autowired
    private TestRestTemplate restTemplate; // can be used to interact the with application like a real client

    @Test
    void createUserTest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>("{\"name\":\"John\",\"email\":\"john@example.com\"}", headers);
        ResponseEntity<User> response = restTemplate.postForEntity("/users", request, User.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("John", response.getBody().getName());
        assertEquals("john@example.com", response.getBody().getEmail());
        assertNotNull(response.getBody().getId());
    }

    @Test
    void createUserandRetrieveUserTest() {

        // save the entity before fetching
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>("{\"name\":\"John\",\"email\":\"john@example.com\"}", headers);
        ResponseEntity<User> savedUserResponse = restTemplate.postForEntity("/users", request, User.class);
        assertNotNull(savedUserResponse.getBody());

        // fetch the saved entity
        ResponseEntity<User> fetchedUserResponse = restTemplate.getForEntity("/users/" + savedUserResponse.getBody().getId(), User.class);

        // check for correct values
        assertEquals(HttpStatus.OK, fetchedUserResponse.getStatusCode());
        assertNotNull(fetchedUserResponse.getBody());
        assertEquals("John", fetchedUserResponse.getBody().getName());
        assertEquals("john@example.com", fetchedUserResponse.getBody().getEmail());
        assertEquals(savedUserResponse.getBody().getId(),fetchedUserResponse.getBody().getId());
    }

    @Test
    void getUserByIdNotFoundTest() {
        ResponseEntity<User> response = restTemplate.getForEntity("/users/1", User.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
