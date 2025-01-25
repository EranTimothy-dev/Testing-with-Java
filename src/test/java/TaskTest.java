import junittesting.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskTest {

    @Test
    public void getId(){
        Task task = new Task();
        assertNotNull(task.getId());
    }


}
