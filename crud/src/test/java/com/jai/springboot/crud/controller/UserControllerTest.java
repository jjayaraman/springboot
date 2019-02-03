package com.jai.springboot.crud.controller;

import org.junit.Assert;
import org.junit.Test;

import com.jai.springboot.crud.entity.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//@formatter:off
public class UserControllerTest {

	private final String API_BASE = "http://localhost:8080";

	@Test
	public void testGetAllUsers() {
		Response res = get(API_BASE + "/users");

		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.getContentType(), "application/json;charset=UTF-8");

		when().get(API_BASE + "/users").then().statusCode(200).contentType(ContentType.JSON);

//		List<User> user = res.getBody().jsonPath().getList("");
//		System.out.println("xxx ::  " + user);

	}

	@Test
	public void testGetUserById() {
		given()
			.pathParam("id", 1)
		.when()
			.get(API_BASE + "/users/{id}")
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.body("id", equalTo(1))
			.body("firstName", equalTo("Jay1"));
	}
	
	@Test
	public void testUpdateUserById() {
		// fail("Not yet implemented");
	}


	@Test
	public void testDeleteUserById() {
		// fail("Not yet implemented");
	}

}
