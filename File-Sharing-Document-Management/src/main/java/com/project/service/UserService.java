package com.project.service;

import com.project.domain.request.CreateUserRequestDto;
import com.project.domain.request.UpdateUserRequestDto;
import com.project.domain.response.AppResponse;
import com.project.model.User;

import java.util.List;

public interface UserService {

    AppResponse saveUser(CreateUserRequestDto requestDto);

    AppResponse ByUserId(int userId);

    AppResponse deleteUser(int userId);

    AppResponse updateUser(UpdateUserRequestDto requestDto,int userId);

    List<User> listAll();
}
