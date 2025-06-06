package timeouttests;

import junittesting.timeouttests.TimeConsumingTask;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class TimeConsumingTaskTest {

    @Test
    public void performTaskCompletesWithinTimeLimit() {
        TimeConsumingTask task = new TimeConsumingTask();
        assertTimeout(Duration.ofSeconds(3), task::performTask, "Task took longer than expected");
    }
}
