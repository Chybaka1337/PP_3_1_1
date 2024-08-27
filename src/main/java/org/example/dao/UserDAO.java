package org.example.dao;

import org.example.model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    void updateUser(User user);
    List<User> getAll();
    User getUserById(int id);
    void deleteUser(int id);
}
