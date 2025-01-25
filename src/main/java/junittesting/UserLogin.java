package junittesting;

import java.util.HashMap;
import java.util.Map;

public class UserLogin {

    private Map<String, String> users;

    public UserLogin() {
        users = new HashMap<>();
        // Prepopulate with some users for testing purposes
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

}
