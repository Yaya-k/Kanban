package com.telecom.kanban.domain;

import com.telecom.kanban.dao.DeveloperRepository;
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
public class TaskTest {
    @Autowired
    private DeveloperRepository developerRepository;

    Collection<Developer> developersList;
    @Before
    public void init() {
        developersList = this.developerRepository.findAll();

    }

    @Test
    public void testAddDeveloper() {

        Developer developer = developersList.iterator().next();

        Assert.assertEquals(2, developer.getTasks().size());

    }
}