package com.verifymultipleinteractions;

public interface UserRepository {
    void save(String username);

    void update(String username);

    void delete(String username);
}
