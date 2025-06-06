package emailvalidator;

import junittesting.emailvalidator.EmailValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorTest {

    private static final EmailValidator underTest = new EmailValidator();

    @ParameterizedTest
    @ValueSource(strings = {
            "user@example.com",
            "user.name@example.com",
            "user123@example.com",
            "user_name@example.com"
    })
    public void valid(String email) {
        assertTrue(underTest.isValid(email));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "user@",
            "@example.com",
            "user@.com",
            "user@ex!ample.com",
            "user@example",
            "user@example.",
            "user@example.123_4"
    })
    public void invalid(String email) {
        assertFalse(underTest.isValid(email));
    }
}