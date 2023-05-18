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

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private  final UserInternalService userInternalService;
	private final MessageSourceService messageSourceService;

	@Override
	public AppResponse saveUser(CreateUserRequestDto requestDto) throws Exception {
		User user = UserHelper.buildCreateUser(requestDto);

		User saveUser = userInternalService.saveUser(user);



		CreateUserResponseDto createUserResponseDto = UserHelper.buildUserResponseDto(saveUser);

		createFolder(saveUser.getEmail());

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

//	@Override
//	public AppResponse getByEmail(String email) {
//		User user = userInternalService.findByEmail(email);
//		return new AppResponse(HttpStatus.OK.value(),
//				"user.retrieved.successfully",
//				"user.retrieved.successfully",
//				UserHelper.buildUserResponseDto(user), null);
//	}

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
	public AppResponse updateUser(UpdateUserRequestDto requestDto,int userId) throws Exception {


		User user = userInternalService.findById(userId);

		user = updateUser(user, requestDto);
		CreateUserResponseDto responseDto = UserHelper.buildUserResponseDto(user);

		return new AppResponse(HttpStatus.OK.value(),
			"user.deleted.successfully",
				"user.deleted.successfully",
				responseDto, null);
		
	}

	private User updateUser(User user, UpdateUserRequestDto requestDto) throws Exception {
		if (StringUtils.isNotBlank(requestDto.getFirstName()))
			user.setFirstName(requestDto.getFirstName());

		if (StringUtils.isNotBlank(requestDto.getLastName()))
			user.setLastName(requestDto.getLastName());

		if (StringUtils.isNotBlank(requestDto.getEmail()))
			user.setEmail(requestDto.getEmail());


		return userInternalService.saveUser(user);
	}

	private  void createFolder(String fname){

		String folderPath = "./src/main/resources/"+fname;
		File folder = new File(folderPath);

		if (!folder.exists()) {
			boolean created = folder.mkdirs();
			if (created) {
				System.out.println("Folder created successfully.");
			} else {
				System.out.println("Failed to create folder.");
			}
		} else {
			System.out.println("Folder already exists.");
		}
	}


}
