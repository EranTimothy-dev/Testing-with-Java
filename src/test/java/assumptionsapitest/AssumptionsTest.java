package assumptionsapitest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumptionsTest {

    @Test
    void onlyIfEnvVarIsSet() {
        String dbUrl = System.getenv("DB_URL");
        assumeTrue(dbUrl != null && !dbUrl.isEmpty(), "Test skipped: DB_URL not set");
        System.out.println("This test runs only if environment variable is set");

        // assumeFalse, assumeNotNull, etc. can be used the same
    }
}
