package com.jai.springboot.mongo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class User implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8180317347147509716L;

	@Id
	private int id;

	private String firstName;

	private String lastName;

	private String userName;

	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", email=" + email + "]";
	}
}
