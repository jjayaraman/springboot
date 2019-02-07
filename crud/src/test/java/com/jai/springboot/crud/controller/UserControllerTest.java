package com.jai.springboot.crud.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jai.springboot.crud.entity.User;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//@formatter:off
public class UserControllerTest {

	@Before
	public void before() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
	}
	
	// Get all records. 200 statusCode
	@Test
	public void testGetAllUsers() {
		given()
		.when()
			.get("/users")
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON);
	}

	// Get existing user. 200 statusCode
	@Test
	public void testGetUserById() {
		given()
			.pathParam("id", 1)
		.when()
			.get("/user/{id}")
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.body("id", equalTo(1));
//			.body("firstName", equalTo("Jay1"));
	}
	
	// Get non existing user. 404 statusCode
	@Test
	public void testGetNonExistingUserById() {
		
		given()
			.pathParam("id", 100)
		.when()
			.get("/user/{id}")
		.then()	
			.statusCode(404);
	}
	
	
	@Test
	public void testCreateUser() {
		User user = new User(6, "Ramya", "Krishnan", "rkrishnan", "rkrishnana@gmail.com");
		
		given()
			.body(user).contentType(ContentType.JSON)
		.when()
			.post("/user")
		.then()
			.statusCode(201);
	}
	
	@Test
	public void testUpdateUser() {
		User user = new User(1, "Ilayaraja", "Isai", "raja", "raja@gmail.com");
		given()
			.body(user).contentType(ContentType.JSON)
		.when()
			.put("/user")
		.then()
			.statusCode(200);
	}


	// Delete existing record. 200 statusCode
	@Test
	public void testDeleteUserById() {
	
		given()
			.pathParam("id", 5)
		.when()
			.delete("/user/{id}")
		.then()
			.statusCode(200);
	}

	// Delete non existing record. 404 statusCode
	@Test
	public void testDeleteNonExistingUserById() {
	
		given()
			.pathParam("id", 100)
		.when()
			.delete("/user/{id}")
		.then()
			.statusCode(404);
	}

}
