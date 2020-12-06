package com.telecom.kanban.service;

import com.telecom.kanban.domain.Developer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")

public class DeveloperServiceTest
{
    @Autowired
    private DeveloperService developerService;

    @Test
    public void testFindAllDevelopers() {
        List<Developer> developers =developerService.findAllDevelopers();

        Assert.assertEquals(1, developers.size());
    }

}