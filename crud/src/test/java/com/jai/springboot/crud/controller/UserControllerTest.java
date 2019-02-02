package com.jai.springboot.crud.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jai.springboot.crud.entity.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class UserControllerTest {

	private final String API_BASE = "http://localhost:8080";

	@Test
	public void test() {
//		fail("Not yet implemented");
	}

	@Test
	public void test1() {
		Response res = get(API_BASE + "/users");

		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.getContentType(), "application/json;charset=UTF-8");

		
		when().
			get(API_BASE + "/users").
		then().
			statusCode(200).
		and().
			contentType(ContentType.JSON);

		List<User> user = res.getBody().jsonPath().getList("");
		System.out.println("xxx ::  " + user);

	}

}
