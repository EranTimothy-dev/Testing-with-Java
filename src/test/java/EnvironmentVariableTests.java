import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

public class EnvironmentVariableTests {

    /**
     * run tests based on the environment variable also a form of conditional execution
     * */

    @Test
    @EnabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "development")
    void developmentEnvironment() {
        System.out.println("This test runs only in the development environment.");
        // Your test logic here
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "development")
    void productionEnvironment() {
        System.out.println("This test does not run in the development environment.");
        // Your test logic here
    }

}
