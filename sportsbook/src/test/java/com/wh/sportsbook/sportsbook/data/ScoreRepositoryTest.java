package com.wh.sportsbook.sportsbook.data;

import com.wh.sportsbook.sportsbook.model.Score;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration testing Repository layer with in-memory H2 database
 *
 * @author Jayakumar Jayaraman
 */
@DataJpaTest
class ScoreRepositoryTest {

    @Autowired
    private ScoreRepository repository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void findAllScores() {
        List<Score> scores = new ArrayList<>();
        repository.findAll().forEach(scores::add);
        Assertions.assertNotNull(scores);
        Assertions.assertEquals(2, scores.size());
    }

    @Test
    public void deleteScore() {
        List<Score> scores = new ArrayList<>();
        repository.findAll().forEach(scores::add);
        Assertions.assertNotNull(scores);
        Assertions.assertEquals(2, scores.size());

        Optional<Score> scoreOptional = repository.findById(1);
        Assertions.assertTrue(scoreOptional.isPresent());
        Score score = scoreOptional.get();

        Assertions.assertNotNull(score);
        repository.delete(score);

        List<Score> scores2 = new ArrayList<>();
        repository.findAll().forEach(scores2::add);
        Assertions.assertNotNull(scores2);
        Assertions.assertEquals(1, scores2.size());
    }


    @Disabled
    @Test
    public void addScore() {
        Score score = new Score(3, "Team C", 0);
        Score created = repository.saveAndFlush(score);
//        entityManager.clear();
        Assertions.assertNotNull(created);
        Assertions.assertEquals(3, created.getId());

        List<Score> scores2 = new ArrayList<>();
        repository.findAll().forEach(scores2::add);
        Assertions.assertNotNull(scores2);
        Assertions.assertEquals(1, scores2.size());
    }
}