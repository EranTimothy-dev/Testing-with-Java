package timeouttests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class TimeoutTest {

    @Test
    @Timeout(5)
    void methodWithTimeout() throws InterruptedException {
        Thread.sleep(6000);
    }
}
