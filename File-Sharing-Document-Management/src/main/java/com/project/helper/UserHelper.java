package com.project.helper;


import com.project.domain.request.CreateUserRequestDto;
import com.project.domain.response.CreateUserResponseDto;
import com.project.model.User;

public class UserHelper {

    public UserHelper() {
    }

    public  static User buildCreateUser(CreateUserRequestDto userRequestDto){

        User user = new User();
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());

        return user;

    }

    public static CreateUserResponseDto buildUserResponseDto(User user){
        return CreateUserResponseDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }


}
