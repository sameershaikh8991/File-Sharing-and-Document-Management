package com.project.service;

import com.project.model.User;

import java.util.List;

public interface UserInternalService {

    User saveUser(User user) throws Exception;

    User findById(int id);

//    User findByEmail(String email);

    void DeleteUserById(int id);

    User updateUser(User user);

    List<User> AllUser();
}
