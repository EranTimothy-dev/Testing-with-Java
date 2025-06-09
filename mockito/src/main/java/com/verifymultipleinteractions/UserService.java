package com.verifymultipleinteractions;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String username) {
        userRepository.save(username);
    }

    public void updateUser(String username) {
        userRepository.update(username);
    }

    public void deleteUser(String username) {
        userRepository.delete(username);
    }
}
