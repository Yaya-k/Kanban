package com.telecom.kanban.dao;

import com.telecom.kanban.domain.TaskStatus;
import org.junit.Assert;
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

public class TaskStatusRepositoryTest
{
    @Autowired
    private TaskStatusRepository taskStatusRepository;

    @Test
    public void testFindAllTaskStatus() {

        Collection<TaskStatus> taskStatusList = this.taskStatusRepository.findAll();

        Assert.assertEquals(4, taskStatusList.size());
    }
}