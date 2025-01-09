import junittesting.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    // setup calculator
    private Calculator underTest = new Calculator();

    // add test
    @Test
    public void testAddition(){
        int result = underTest.add(2,3);
        assertEquals(5, result);
    }
}
