package junittesting.testsuites;

import java.util.ArrayList;
import java.util.List;

public class UserRegistration {

    private List<String> users;

    public UserRegistration() {
        this.users = new ArrayList<>();
    }

    public boolean registerUser(String username) {
        if (isValidUsername(username)) {
            users.add(username);
            return true;
        }
        return false;
    }

    public boolean isValidUsername(String username) {
        return username != null && !username.trim().isEmpty() && username.length() >= 3;
    }

    public List<String> getUsers() {
        return users;
    }

}
