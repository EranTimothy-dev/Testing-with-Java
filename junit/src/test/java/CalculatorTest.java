import extensions.TimingExtensionTest;
import junittesting.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TimingExtensionTest.class)
public class CalculatorTest {

    // setup calculator
    private Calculator underTest = new Calculator();

    // add test
    @Test
    public void testAddition(){
        int result = underTest.add(2,3);
        assertEquals(5, result, () -> "The answer is incorrect"); // using message suppliers by making the message
        // an anonymous function which only creates the message if the test fails, making it more efficient
    }

    @Test
    public void division(){
        int result = underTest.divide(6,2);
        assertNotEquals(4,result);
    }

    @Test
    public void isEven(){
        boolean result = underTest.isEven(4);
        assertTrue(result);
    }

    @Test
    public void isEvenWithOddNumber(){
        boolean result = underTest.isEven(5);
        assertFalse(result);
    }

    @Test
    public void divideByZero(){
//        Integer result = null;
//        try{
//            result = underTest.divide(6,0);
//        } catch (ArithmeticException e){
//            // Division by zero occurred
//        }
//        assertNull(result, "Division by zero results in a null value");

        ArithmeticException e = assertThrows(ArithmeticException.class, () -> underTest.divide(10,0));
        assertEquals("/ by zero", e.getMessage());
    }

    @Test
    void divideNonZero(){
        Integer result = underTest.divide(10,2);
        assertNotNull(result);
        assertEquals(5,result);
    }
}
