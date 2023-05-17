package com.project.controller;

import com.project.domain.request.CreateUserRequestDto;
import com.project.domain.response.AppResponse;
import com.project.model.User;
import com.project.service.userService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {



	private final userService userService;


	
	@PostMapping(value = "/saveUser")
	public ResponseEntity<AppResponse>  saveUser(@RequestBody CreateUserRequestDto requestDto) {

		AppResponse appResponse = userService.saveUser(requestDto);
		return ResponseEntity.ok().body(appResponse);
	}
	@GetMapping(value = "/{userId}")
	public User getUser(@PathVariable int userId) {
    User us = userService.listByUserId(userId);

		return us;
	}
	
	@DeleteMapping(value = "/deleteUser/{userId}")
	public void delete(@PathVariable int userId) {

		userService.deleteUser(userId);
		
	}
	
	@PutMapping("/updateUser/{userId}")
	public User updateUser(@PathVariable int userId,@RequestBody User user) {
		user.setUserId(userId);
		return userService.updateUser(user);
	}

}
