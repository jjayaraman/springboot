package com.jai.springjpa.repository;

import com.jai.springjpa.entity.Component;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ComponentRepositoryTest {

    @Autowired
    ComponentRepository componentRepository;

    @Test
    public void testCrud() {
        // Create
        Component component = new Component();
        component.setCasNumber("78-89-xx");
        component.setDescription("Some compound");
        component.setOrganic(true);
        Component saved = componentRepository.save(component);
        Assert.assertNotNull(saved);
        Long id = saved.getId();

        // Read
        Optional<Component> foundOptional = componentRepository.findById(id);
        Assert.assertEquals(true,foundOptional.isPresent());
        Component found = foundOptional.get();
        Assert.assertEquals(id, found.getId());

        // Update
        found.setCasNumber("99-99-99");
        found.setDescription("updated description");
        found.setOrganic(false);
        Component updated = componentRepository.save(found);
        Assert.assertEquals(id, updated.getId());
        Assert.assertEquals("99-99-99", updated.getCasNumber());
        Assert.assertFalse(updated.isOrganic());

        // Delete
        componentRepository.deleteById(id);

        Optional<Component> notFound = componentRepository.findById(id);
        Assert.assertEquals(false,notFound.isPresent());

        System.out.println("saved : " +saved);
        System.out.println("found : " +foundOptional);
    }
}