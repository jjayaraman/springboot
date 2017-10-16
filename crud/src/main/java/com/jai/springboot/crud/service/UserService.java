package com.jai.springboot.crud.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jai.springboot.crud.dao.UserDao;
import com.jai.springboot.crud.entity.User;

/**
 * Service for user
 * 
 * @author jjayaraman
 *
 */
@Service
public class UserService {

	@Autowired
	UserDao userDao;

	/**
	 * Get users
	 * 
	 * @return
	 */
	public Map<Integer, User> getUsers() {
		return userDao.getUsers();
	}

	/**
	 * Get a user by id
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	/**
	 * Removes a record
	 * 
	 * @param id
	 */
	public void delete(int id) {
		userDao.delete(id);
	}

	/**
	 * Adds a record
	 * 
	 * @param id
	 */
	public void add(User user) {
		userDao.add(user);
	}

	/**
	 * Updates
	 * 
	 * @param user
	 */
	public void update(User user) {
		userDao.update(user);
	}
}
