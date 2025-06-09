package com.mockingobjects;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(String userId) {
        return userRepository.findById(userId);
    }
}
