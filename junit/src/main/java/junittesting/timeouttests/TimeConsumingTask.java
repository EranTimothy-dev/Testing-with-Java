package junittesting.timeouttests;

public class TimeConsumingTask {

    public void performTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
