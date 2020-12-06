package com.telecom.kanban.dao;

import com.telecom.kanban.domain.TaskType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")

public class TaskTypeRepositoryTest
{
    @Autowired
    private TaskTypeRepository taskTypeRepository;

    @Test
    public void testFindAllTaskStatus() {

        Collection<TaskType> taskTypeList = this.taskTypeRepository.findAll();

        Assert.assertEquals(2, taskTypeList.size());
    }
}