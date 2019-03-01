package com.jai.springboot.mongo.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.jai.springboot.mongo.data.UserRepository;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
// @SpringBootTest
@WebMvcTest(UserController.class)
public class UserControllerTest {

	// @Autowired
	// UserController controller;

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserRepository userRepository;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHome() throws Exception {
		when(userRepository.count()).thenReturn(new Long(1));
		this.mockMvc.perform(MockMvcRequestBuilders.get("/users")).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
		this.mockMvc.perform(MockMvcRequestBuilders.get("/users/count")).andExpect(MockMvcResultMatchers.content().string("1"));
	}
}
