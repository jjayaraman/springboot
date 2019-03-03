package com.jai.springboot.mongo.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jai.springboot.mongo.entity.Address;
import com.jai.springboot.mongo.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

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
	public void testCount() {
		Assert.assertEquals(2, userRepository.count());
	}

	@Test
	public void testCreate() {
		User user = new User("Jay", "Kumar", "jkumar", "jkumar@gmail.com");
		User created = userRepository.save(user);
		Assert.assertNotNull(created);
	}

	@Test
	public void testFindAll() {

		List<User> users = userRepository.findAll();
		users.stream().forEach(user -> System.out.println(user));
		Assert.assertEquals(2, users.size());
	}

	@Test
	public void testFindById() {

		Optional<User> user = userRepository.findById("1");
		Assert.assertEquals("1", user.get().getId());
		System.out.println("user :: " + user);
	}
	
	
	@Test
	public void testUpdate() {

		Optional<User> userOptional = userRepository.findById("1");
		User user = userOptional.get();
		Assert.assertEquals("1", user.getId());
		System.out.println("user :: " + user);
		user.setFirstName("Jay");
		userRepository.save(user);
	}
	
	@Test
	public void testDelete() {

		Optional<User> userOptional = userRepository.findById("3");
		User user = userOptional.get();
		Assert.assertEquals("3", user.getId());
		System.out.println("user :: " + user);
		userRepository.delete(user);
	}

	
	@Test
	public void testFindByFirstName() {
		System.out.println(userRepository.findByFirstName("Jay"));
	}
	
	@Test
	public void testFindByLastName() {
		System.out.println(userRepository.findByLastName("Kumar"));
	}


	@Test
	public void testCreate2() {
		User user = new User("4", "Jay", "Kumar", "jkumar", "jkumar@gmail.com");
		
		List<Address> addresses = new ArrayList<Address>();
		Address address1 = new Address("2", "1 Great street", "New Road", "AB1 2XX", "London", "UK");
		addresses.add(address1);
		user.setAddresses(addresses);
		userRepository.save(user);
		
	}

}
