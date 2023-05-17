package com.project.service;

import com.project.model.User;

import java.util.List;

public interface userInternalService {

    User saveUser(User user);

    User findById(int id);

    void DeleteUserById(int id);

    User updateUser(User user);

    List<User> AllUser();
}
