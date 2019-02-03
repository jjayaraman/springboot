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
	
	@Test
	public void testGetAllUsers() {
		Response res = get("/users");

		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.getContentType(), "application/json;charset=UTF-8");
		
		given()
		.when()
			.get("/users")
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON);
	}

	@Test
	public void testGetUserById() {
		given()
			.pathParam("id", 1)
		.when()
			.get("/user/{id}")
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.body("id", equalTo(1))
			.body("firstName", equalTo("Jay1"));
	}
	
	@Test
	public void testGetNonExistingUserById() {
		
		given()
			.pathParam("id", 100)
		.when()
			.get("/user/{id}")
		.then()	
			.statusCode(204);
	}
	
	@Test
	public void testUpdateUserById() {
		// fail("Not yet implemented");
	}


	@Test
	public void testDeleteUserById() {
	
		given()
			.pathParam("id", 5)
		.when()
			.delete("/user/{id}")
		.then()
			.statusCode(200);
	}

	@Test
	public void testNonExistingUserById() {
	
		given()
			.pathParam("id", 100)
		.when()
			.delete("/user/{id}")
		.then()
			.statusCode(404);
	}

}
