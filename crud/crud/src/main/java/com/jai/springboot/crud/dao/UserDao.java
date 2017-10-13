package com.jai.springboot.crud.dao;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jai.springboot.crud.entity.User;

/**
 * User DAO
 * 
 * @author jjayaraman
 *
 */
@Repository
public class UserDao {

	// Data store for simple testing
	private static Hashtable<Integer, User> users = new Hashtable<Integer, User>();

	static {
		users.put(1, new User(1, "Jay1", "ram1", "jram1", "jram1@gmail.com"));
		users.put(2, new User(2, "Jay2", "ram2", "jram2", "jram2@gmail.com"));
		users.put(3, new User(3, "Jay3", "ram3", "jram3", "jram3@gmail.com"));
		users.put(4, new User(4, "Jay4", "ram4", "jram4", "jram4@gmail.com"));
		users.put(5, new User(5, "Jay5", "ram5", "jram5", "jram5@gmail.com"));
	}

	/**
	 * Get users
	 * 
	 * @return
	 */
	public Map<Integer, User> getUsers() {
		return users;
	}

	/**
	 * Get a user by id
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(int id) {
		return users.get(id);
	}

}
