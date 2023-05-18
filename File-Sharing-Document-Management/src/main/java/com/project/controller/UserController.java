package com.project.controller;

import com.project.domain.request.CreateUserRequestDto;
import com.project.domain.request.UpdateUserRequestDto;
import com.project.domain.response.AppResponse;
import com.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {



	private final UserService userService;

	@PostMapping(value = "/saveUser")
	public ResponseEntity<AppResponse>  saveUser(@RequestBody CreateUserRequestDto requestDto) throws Exception {

		AppResponse appResponse = userService.saveUser(requestDto);
		return ResponseEntity.ok().body(appResponse);
	}
	@GetMapping(value = "/{userId}")
	public ResponseEntity<AppResponse>  getUser(@PathVariable int userId) {
		return ResponseEntity.ok().body(userService.ByUserId(userId));
	}
	
	@DeleteMapping(value = "/deleteUser/{userId}")
	public  ResponseEntity<AppResponse> delete(@PathVariable int userId) {

		return ResponseEntity.ok().body(userService.deleteUser(userId));
	}
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<AppResponse> updateUser(@PathVariable int userId,@RequestBody UpdateUserRequestDto requestDto) throws Exception {
		return ResponseEntity.ok().body(userService.updateUser(requestDto, userId));
	}








}
