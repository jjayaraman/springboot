package com.jai.springboot.crud.postgre.controller;

import com.jai.springboot.crud.postgre.exception.ResourceNotFoundException;
import com.jai.springboot.crud.postgre.entity.User;
import com.jai.springboot.crud.postgre.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable(name = "id") int id) {

        Optional<User> foundUser = userRepository.findById(id);
        if (!foundUser.isPresent()) {
            throw new ResourceNotFoundException("User not found");
        }
        return foundUser;
    }

    @PostMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }


    @PutMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody User user) {
        Optional<User> foundUser = userRepository.findById(user.getId());
        if (!foundUser.isPresent()) {
            throw new ResourceNotFoundException("User not found");
        }

        return userRepository.save(user);
    }

    @DeleteMapping(path = "/user/{id}")
    public void deleteUser(@PathVariable(name = "id") Integer id) {

        Optional<User> foundUser = userRepository.findById(id);
        if (!foundUser.isPresent()) {
            throw new ResourceNotFoundException("User not found");
        }

        userRepository.delete(foundUser.get());
    }


}
