package com.jai.springboot.mongo.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jai.springboot.mongo.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
	User findByLastName(String lastName);
	List<User> findByFirstName(String firstName);
}
