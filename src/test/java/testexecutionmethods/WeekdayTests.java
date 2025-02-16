package testexecutionmethods;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekdayTests {

    /**
     * Execute tests based on a given condition, in this case it is based on the output of the funciton
     * "isWeekday", this is also another method of conditional execution.
     * */

    @Test
    @EnabledIf("isWeekday")
    void weekdays() {
        System.out.println("This test runs only on weekdays.");
        // Your test logic here
    }

    @Test
    @DisabledIf("isWeekday")
    void weekends() {
        System.out.println("This test runs only on weekends.");
        // Your test logic here
    }

    // Custom method to determine if it's a weekday
    private boolean isWeekday() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
    }

}
