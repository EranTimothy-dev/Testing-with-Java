import junittesting.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskTest {

    private Task task;

    @BeforeEach
    void setUp(){
        task = new Task("Read a book");
    }

    @Test
    public void getId(){
        assertNotNull(task.getId());
    }

    @Test
    public void getDescription(){
        String result = task.getDescription();
        assertEquals("Read a book", result);
    }

    @Test
    public void setDescription(){
        task.setDescription("Pack for summer trip");
        assertEquals("Pack for summer trip", task.getDescription());
    }


}
