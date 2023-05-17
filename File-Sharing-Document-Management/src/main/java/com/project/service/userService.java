package com.project.service;

import com.project.domain.request.CreateUserRequestDto;
import com.project.domain.response.AppResponse;
import com.project.model.User;

import java.util.List;

public interface userService {

    AppResponse saveUser(CreateUserRequestDto requestDto);

    User listByUserId(int userId);

    void deleteUser(int userId);

    User updateUser(User user);

    List<User> listAll();
}
