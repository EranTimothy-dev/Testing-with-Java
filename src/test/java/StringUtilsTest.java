import junittesting.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTest {

    @Test
    void isPalindromeWithEmptyString() {
        assertTrue(StringUtils.isPalindrome(""));
    }

    @Test
    void isPalindromeWithSingleCharacter() {
        assertTrue(StringUtils.isPalindrome("a"));
    }

    @Test
    void isPalindromeWithPalindromeString() {
        assertTrue(StringUtils.isPalindrome("racecar"));
    }

    @Test
    void isPalindromeWithNonPalindromeString() {
        assertFalse(StringUtils.isPalindrome("hello"));
    }

    @Test
    void isPalindromeWithMixedCasePalindromeString() {
        assertTrue(StringUtils.isPalindrome("RaceCar"));
    }

}
