package testsuites;

import junittesting.testsuites.UserLogin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserLoginTest {

    private UserLogin userLogin;

    @BeforeEach
    void setUp() {
        userLogin = new UserLogin();
    }

    @Test
    void validLogin() {
        assertTrue(userLogin.login("user1", "password1"));
        assertTrue(userLogin.login("user2", "password2"));
    }

    @Test
    void invalidLogin() {
        assertFalse(userLogin.login("user1", "wrongpassword"));
        assertFalse(userLogin.login("user2", "wrongpassword"));
        assertFalse(userLogin.login("nonexistentuser", "password"));
    }

    @Test
    void loginWithNullUsername() {
        assertFalse(userLogin.login(null, "password1"));
    }

    @Test
    void loginWithNullPassword() {
        assertFalse(userLogin.login("user1", null));
    }

    @Test
    void loginWithNullUsernameAndPassword() {
        assertFalse(userLogin.login(null, null));
    }

}
