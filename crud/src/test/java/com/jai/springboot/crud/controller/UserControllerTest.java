package com.jai.springboot.crud.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jai.springboot.crud.entity.User;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserControllerTest {

	private final String API_BASE = "http://localhost:8080";

	@Test
	public void test() {
//		fail("Not yet implemented");
	}

	@Test
	public void test1() {
		Response res = RestAssured.get(API_BASE + "/users");

		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.getContentType(), "application/json;charset=UTF-8");

		List<User> user = res.getBody().jsonPath().getList("");
		System.out.println("xxx ::  " + user);
	}

}
