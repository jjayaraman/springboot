package com.jai.springboot.jpamysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody User user) {
		userRepository.save(user);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public void delete(@PathVariable long id) {
		userRepository.delete(id);
	}

}
