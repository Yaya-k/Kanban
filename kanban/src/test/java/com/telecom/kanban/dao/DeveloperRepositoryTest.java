package com.telecom.kanban.dao;

import com.telecom.kanban.domain.Developer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class DeveloperRepositoryTest {
    @Autowired
    private DeveloperRepository developerRepository;

    Collection<Developer> developersList;
    @Before
    public void init() {
       developersList = this.developerRepository.findAll();

    }
 @Test
    public void testFindAllTasks() {
     Assert.assertEquals(1, developersList.size());

    }


}