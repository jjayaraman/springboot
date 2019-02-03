package com.jai.springboot.crud.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jai.springboot.crud.entity.User;
import com.jai.springboot.crud.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/users")
	public Map<Integer, User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping(path = "/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable(name = "id") int id) {
		User user = userService.getUser(id);
		if(user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}else {
			return ResponseEntity.noContent().build();	
		}
	}

	@PostMapping(path = "/user", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void add(@RequestBody User user) {
		userService.add(user);
	}

	@PutMapping(path = "/user", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		
		User existingUser = userService.getUser(user.getId());
		if(existingUser != null) {
			userService.update(user);
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(path = "/user/{id}")
	public ResponseEntity<User> delete(@PathVariable(name = "id") int id) {
		User user = userService.getUser(id);
		if (user != null) {
			userService.delete(id);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // Twitter uses 404
		}
	}
}
