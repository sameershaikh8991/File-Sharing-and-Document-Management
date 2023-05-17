package com.project.service.impl;


import com.project.domain.request.CreateUserRequestDto;
import com.project.domain.request.UpdateUserRequestDto;
import com.project.domain.response.AppResponse;
import com.project.domain.response.CreateUserResponseDto;
import com.project.helper.UserHelper;
import com.project.model.User;
import com.project.service.MessageSourceService;
import com.project.service.UserInternalService;
import com.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private  final UserInternalService userInternalService;
	private final MessageSourceService messageSourceService;

	@Override
	public AppResponse saveUser(CreateUserRequestDto requestDto) {
		User user = UserHelper.buildCreateUser(requestDto);

		User saveUser = userInternalService.saveUser(user);

		CreateUserResponseDto createUserResponseDto = UserHelper.buildUserResponseDto(saveUser);

		return new AppResponse(HttpStatus.CREATED.value(),
				"user.created.successfully",
				"user.created.successfully",
				createUserResponseDto, null);
	}

	@Override
	public AppResponse ByUserId(int userId) {

		User user = userInternalService.findById(userId);
		return new AppResponse(HttpStatus.OK.value(),
				"user.retrieved.successfully",
				"user.retrieved.successfully",
				UserHelper.buildUserResponseDto(user), null);

	}

	@Override
	public AppResponse deleteUser(int userId) {
		userInternalService.DeleteUserById(userId);
		return new AppResponse(HttpStatus.OK.value(),
				"user.deleted.successfully",
				"user.deleted.successfully",
				null, null);
	}

	@Override
	public List<User> listAll() {

		return userInternalService.AllUser();
	}

	@Override
	public AppResponse updateUser(UpdateUserRequestDto requestDto,int userId) {


		User user = userInternalService.findById(userId);

		user = updateUser(user, requestDto);
		CreateUserResponseDto responseDto = UserHelper.buildUserResponseDto(user);

		return new AppResponse(HttpStatus.OK.value(),
			"user.deleted.successfully",
				"user.deleted.successfully",
				responseDto, null);
		
	}

	private User updateUser(User user, UpdateUserRequestDto requestDto) {
		if (StringUtils.isNotBlank(requestDto.getUserName()))
			user.setUserName(requestDto.getUserName());

		if (StringUtils.isNotBlank(requestDto.getUserEmail()))
			user.setUserEmail(requestDto.getUserEmail());


		return userInternalService.saveUser(user);
	}


}
