import junittesting.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    // setup calculator
    private Calculator underTest = new Calculator();

    // add test
    @Test
    public void testAddition(){
        int result = underTest.add(2,3);
        assertEquals(5, result);
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
        Integer result = null;
        try{
            result = underTest.divide(6,0);
        } catch (ArithmeticException e){
            // Division by zero occurred
        }
        assertNull(result);
    }

    @Test
    void divideNonZero(){
        Integer result = underTest.divide(10,2);
        assertNotNull(result);
        assertEquals(5,result);
    }
}
