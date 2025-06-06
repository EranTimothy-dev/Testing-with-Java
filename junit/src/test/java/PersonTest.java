import junittesting.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void personFieldsTest() {
        Person person = new Person("John Doe", 30, "john.doe@example.com", "Colombo");
        // checks all the conditions together instead of quiting at the first failed assertion
        assertAll("Person Fields",
                () -> assertEquals("John Doe", person.getName()),
                () -> assertEquals(31, person.getAge()),
                () -> assertEquals("john.doe@example.com", person.getEmail()),
                () -> assertEquals("Colombo 2", person.getAddress())
        );
    }
}
