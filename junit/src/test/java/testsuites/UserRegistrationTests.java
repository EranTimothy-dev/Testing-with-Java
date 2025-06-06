package testsuites;

import junittesting.testsuites.UserRegistration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTests {

    @Test
    public void validUserRegistration() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.registerUser("validUser");
        assertTrue(result);
        assertEquals(1, userRegistration.getUsers().size());
        assertEquals("validUser", userRegistration.getUsers().get(0));
    }

    @Test
    public void invalidUserRegistration() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.registerUser("");
        assertFalse(result);
        assertTrue(userRegistration.getUsers().isEmpty());

        result = userRegistration.registerUser(null);
        assertFalse(result);
        assertTrue(userRegistration.getUsers().isEmpty());

        result = userRegistration.registerUser("ab");
        assertFalse(result);
        assertTrue(userRegistration.getUsers().isEmpty());
    }

    @Test
    public void isValidUsername() {
        UserRegistration userRegistration = new UserRegistration();
        assertFalse(userRegistration.isValidUsername(""));
        assertFalse(userRegistration.isValidUsername(null));
        assertFalse(userRegistration.isValidUsername("ab"));
        assertTrue(userRegistration.isValidUsername("validUser"));
    }

}
