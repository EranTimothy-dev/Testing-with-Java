import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionTest {

    @Test
    @DisplayName("Addition should return correct name") // giving descriptive names for tests
    void additionTest(){
        int result = 2 + 2;
        assertEquals(4,result, "2 +2  should equal to 4");
    }
}
