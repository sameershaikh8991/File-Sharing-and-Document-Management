package com.project.service.impl;


import com.project.domain.request.CreateUserRequestDto;
import com.project.domain.response.AppResponse;
import com.project.domain.response.CreateUserResponseDto;
import com.project.helper.UserHelper;
import com.project.model.User;
import com.project.repository.UserRepository;
import com.project.service.MessageSourceService;
import com.project.service.userService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements userService {


	private final UserRepository userRepository;

	private final MessageSourceService messageSourceService;

	@Override
	public AppResponse saveUser(CreateUserRequestDto requestDto) {
		User user = UserHelper.buildCreateUser(requestDto);

		User saveUser = userRepository.save(user);

		CreateUserResponseDto createUserResponseDto = UserHelper.buildUserResponseDto(saveUser);

		return new AppResponse(HttpStatus.CREATED.value(),
				messageSourceService.getMessageByKey("user.created.successfully"),
				messageSourceService.getMessageByKey("user.created.successfully"),
				createUserResponseDto, null);
	}

	@Override
	public User listByUserId(int userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public List<User> listAll() {

		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		
		return userRepository.save(user);
	}


}
