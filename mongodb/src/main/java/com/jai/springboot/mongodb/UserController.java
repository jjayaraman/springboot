package com.jai.springboot.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	 UserRepository userMongoRepository;

	@RequestMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers() {
		return userMongoRepository.findAll();
	}

}
