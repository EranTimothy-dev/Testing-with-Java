package testdrivendevelopment;

import junittesting.testdrivendevelopment.Task;
import junittesting.testdrivendevelopment.TaskManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    private TaskManager taskManager;
    private Task task;

    @BeforeEach
    void setup(){
        taskManager = new TaskManager();
        task = new Task("Read a book");
        assertEquals(0,taskManager.count());
    }


    @Test
    public void addTask(){
        taskManager.add(task);

        assertTrue(taskManager.exists(task.getId()));
        assertEquals(1, taskManager.count());
    }

    @Test
    public void addTask_duplicateTasks(){
        Task task1 = new Task("Make presentation");

        taskManager.add(task1);
        taskManager.add(task);
        assertTrue(taskManager.exists(task1.getId()));
        assertTrue(taskManager.exists(task.getId()));
        assertEquals(2,taskManager.count());
    }


    @Test
    public void removeTask(){
        taskManager.add(task);
        int preTaskCount = taskManager.count();

        taskManager.remove(task.getId());

        assertFalse(taskManager.exists(task.getId()));
        assertEquals(preTaskCount-1,taskManager.count());
    }

    @Test
    public void getTask(){
        taskManager.add(task);

        Task result = taskManager.get(task.getId());

        assertEquals(task,result);
    }

}
