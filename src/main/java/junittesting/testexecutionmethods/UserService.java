package junittesting.testexecutionmethods;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserService {

    private static Map<String, User> userDatabase = new HashMap<>();

    public void createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        userDatabase.put(user.getId(), user);
    }

    public void updateUser(User user) {
        userDatabase.put(user.getId(), user);
    }

    public User getUserById(String id) {
        return userDatabase.get(id);
    }

    public void deleteUser(String id) {
        userDatabase.remove(id);
    }

}
