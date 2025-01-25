import junittesting.User;
import junittesting.UserService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // this specifies that the Order annotation will specify the order of execution.
public class UserManagementTests {

    /**
     * since all tests share the same userService the order in which the tests run would matter since if the
     * delete test is called and there is no user to update the test will fail, this can be achieved with the
     * TestMethodOrder and Order annotations to specify the order of which the tests should run.
     * */

    private static User testUser;
    private static UserService userService = new UserService();

    @Test
    @Order(2)
    void updateUser() {
        assertNotNull(testUser, "Test user should exist");
        testUser.setFirstName("Joe");
        testUser.setLastName("Smith");
        userService.updateUser(testUser);
        User updatedUser = userService.getUserById(testUser.getId());
        assertEquals("Joe", updatedUser.getFirstName(), "First name should be updated");
        assertEquals("Smith", updatedUser.getLastName(), "Last name should be updated");
        System.out.println("Update User Test");
    }

    @Test
    @Order(1)
    void createUser() {
        testUser = new User("john_smith", "John", "Smith", "john.doe@example.com");
        userService.createUser(testUser);
        assertNotNull(testUser.getId(), "User ID should be generated");
        System.out.println("Create User Test");
    }

    @Test
    @Order(3)
    void getUser() {
        assertNotNull(testUser, "Test user should exist");
        User fetchedUser = userService.getUserById(testUser.getId());
        assertNotNull(fetchedUser, "Fetched user should not be null");
        assertEquals(testUser.getId(), fetchedUser.getId(), "User ID should match");
        System.out.println("Get User Test");
    }

    @Test
    @Order(4)
    void deleteUser() {
        assertNotNull(testUser, "Test user should exist");
        userService.deleteUser(testUser.getId());
        User deletedUser = userService.getUserById(testUser.getId());
        assertNull(deletedUser, "Deleted user should be null");
        System.out.println("Delete User Test");
    }

}
