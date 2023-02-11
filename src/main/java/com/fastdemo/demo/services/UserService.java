package com.fastdemo.demo.services;

import com.fastdemo.demo.models.UserModel;
import com.fastdemo.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public ResponseEntity<List<UserModel>> getAllUsers() {
		try {
			List<UserModel> users = new ArrayList<>(userRepository.findAll());

			if(users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<UserModel> createUser(UserModel newUser) {
		UserModel user = new UserModel();

		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());

		try{
			userRepository.save(user);

			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
