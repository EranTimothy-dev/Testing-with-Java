package ParameterizedTests;

import junittesting.ParameterizedTests.StringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "a", "racecar", "RaceCar"})
    public void isPalidrome(String str){
        assertTrue(StringUtils.isPalindrome(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", "world", "java", "Junit"})
    public void isNotPalindrome(String str){
        assertFalse(StringUtils.isPalindrome(str));
    }

//    @Test
//    void isPalindromeWithEmptyString() {
//        assertTrue(StringUtils.isPalindrome(""));
//    }
//
//    @Test
//    void isPalindromeWithSingleCharacter() {
//        assertTrue(StringUtils.isPalindrome("a"));
//    }
//
//    @Test
//    void isPalindromeWithPalindromeString() {
//        assertTrue(StringUtils.isPalindrome("racecar"));
//    }
//
//    @Test
//    void isPalindromeWithNonPalindromeString() {
//        assertFalse(StringUtils.isPalindrome("hello"));
//    }
//
//    @Test
//    void isPalindromeWithMixedCasePalindromeString() {
//        assertTrue(StringUtils.isPalindrome("RaceCar"));
//    }

}
