package com.testingasynchronouscode;

import java.util.concurrent.CompletableFuture;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CompletableFuture<User> getUserById(String userId) {
        return CompletableFuture.supplyAsync(() -> userRepository.findById(userId));
    }
}
