package com.jai.springboot.mongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jai.springboot.mongo.data.UserRepository;
import com.jai.springboot.mongo.entity.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	UserRepository userRepository;

	/**
	 * @param userRepository
	 */
	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> getUsers() {
		return userRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<User> getUserById(@PathVariable String id) {
		return userRepository.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody User user) {
		userRepository.save(user);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody User user) {
		userRepository.save(user);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public void delete(@PathVariable String id) {
		userRepository.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@RequestMapping(path = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long count() {
		return userRepository.count();
	}

}
