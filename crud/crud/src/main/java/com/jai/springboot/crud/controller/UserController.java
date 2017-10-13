package com.jai.springboot.crud.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jai.springboot.crud.entity.User;
import com.jai.springboot.crud.service.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public Map<Integer, User> getUsers() {
		return userService.getUsers();
	}

	/**
	 * Get a user by id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable(name = "id") int id) {
		return userService.getUser(id);
	}

}
