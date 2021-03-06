package com.jai.springboot.crud.postgre.controller;

import com.jai.springboot.crud.postgre.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Integration tests
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerIntegrationTest {

    @Autowired
    UserController controller;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void a_createUser() {
        User user = new User(10,"kumar","ahmedabad");
        controller.createUser(user);
    }


    @Test
    public void b_getUserById() {
        Optional<User> user = controller.getUserById(10);
        assertEquals(true, user.isPresent());

    }

    @Test
    public void c_updateUser() {
        Optional<User> userOptional = controller.getUserById(10);
        User user = userOptional.get();
        user.setName("modified");
        User updated = controller.updateUser(user);

        assertEquals("modified", updated.getName());
    }

    @Test
    public void d_getUsers() {
        List<User> users = controller.getUsers();
        assertNotNull(users);
    }

    @Test
    public void z_deleteUser() {
        controller.deleteUser(10);
    }
}