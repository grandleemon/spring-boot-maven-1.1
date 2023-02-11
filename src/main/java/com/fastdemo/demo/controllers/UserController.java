package com.fastdemo.demo.controllers;

import com.fastdemo.demo.models.UserModel;
import com.fastdemo.demo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserModel>> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/users")
	public ResponseEntity<UserModel> createUser(@RequestBody UserModel newUser) {
		return userService.createUser(newUser);
	}
}
