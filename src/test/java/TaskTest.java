import junittesting.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskTest {

    @Test
    public void getId(){
        Task task = new Task("Write outline for article");
        assertNotNull(task.getId());
    }

    @Test
    public void getDescription(){
        Task task = new Task("Read a book");
        String result = task.getDescription();
        assertEquals("Read a book", result);
    }


}
