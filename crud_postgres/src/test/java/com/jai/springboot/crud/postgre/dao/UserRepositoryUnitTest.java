package com.jai.springboot.crud.postgre.dao;

import com.jai.springboot.crud.postgre.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserRepositoryUnitTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void createUser() {

        // given
        User user = new User(20, "datajpatest", "lux");
        entityManager.persist(user);
        entityManager.flush();

        // when
        Optional<User> userOptional = repository.findById(20);

        if (userOptional.isPresent()) {
            User found = userOptional.get();

            //then
            assertThat(found).isNotNull();
            assertThat(found.getId()).isEqualTo(20);
            assertThat(found.getName()).isEqualTo("datajpatest");
            assertThat(found.getCity()).isEqualTo("lux");

        }
    }
}