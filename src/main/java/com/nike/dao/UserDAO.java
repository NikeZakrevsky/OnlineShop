package com.nike.dao;

import com.nike.model.User;

import java.util.Set;

public interface UserDAO {
    void saveUser(User user);
    User getUserByName2(String name);
    Set<User> getUserList();
    User getUserByName(User user);
}
