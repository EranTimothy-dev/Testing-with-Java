import junittesting.Task;
import junittesting.TaskManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    @Test
    public void addTask(){
        TaskManager taskManager = new TaskManager();
        Task task = new Task();
        taskManager.add(task);

        assertTrue(taskManager.exists(task.getId()));
    }

    @Test
    public void addTask_duplicateTasks(){
        TaskManager taskManager = new TaskManager();
        Task task1 = new Task();
        Task task2 = new Task();

        taskManager.add(task1);
        taskManager.add(task2);
        assertTrue(taskManager.exists(task1.getId()));
        assertTrue(taskManager.exists(task2.getId()));
        assertEquals(2,taskManager.count());
    }


    @Test
    public void removeTask(){
        TaskManager taskManager = new TaskManager();
        Task task = new Task();
        taskManager.add(task);
        int preTaskCount = taskManager.count();

        taskManager.remove(task.getId());

        assertFalse(taskManager.exists(task.getId()));
        assertEquals(preTaskCount-1,taskManager.count());
    }


}
