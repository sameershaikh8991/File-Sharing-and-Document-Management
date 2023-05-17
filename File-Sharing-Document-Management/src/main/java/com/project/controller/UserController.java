package com.project.controller;

import com.project.model.User;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {


	@Autowired
	private UserService userService;


	
	@PostMapping(value = "/saveUser")
	public User saveUser(@RequestBody User user) {
		User us = userService.saveUser(user);
		return us;
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
