package com.telecom.kanban.service;

import com.telecom.kanban.domain.Task;
import com.telecom.kanban.domain.TaskStatus;
import com.telecom.kanban.domain.TaskType;
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

public class TaskServiceTest
{
    @Autowired
    private TaskService taskService;

    @Test
    public void testFindTaskStatus() {
        TaskStatus taskStatus= taskService.findTaskStatus(1L);

        Assert.assertEquals("TODO", taskStatus.getLabel());
   }
    @Test
    public void testFindTaskType(){
        TaskType taskType=taskService.findTaskType(1L);

        Assert.assertEquals(1L,(Object)taskType.getId());
    }

    @Test
    public void testFindAllTasks() {
        Collection<Task> tasks= taskService.findAllTasks();

        Assert.assertEquals(2, tasks.size());
    }
    @Test
    public void testFindTask(){
        Task task=taskService.findTask(1L);

        Assert.assertEquals("feature login",task.getTitle());
    }

    @Test
    public void testFindAllTaskStatus() {
        Collection<TaskStatus> taskStatus= taskService.findAllTaskStatus();

        Assert.assertEquals(4, taskStatus.size());
    }

    @Test
    public void testFindAllTaskType(){
        Collection<TaskType> taskTypes=taskService.findAllTaskType();

        Assert.assertEquals(2,taskTypes.size());
    }

    @Test
    public void testCreateTask() {
        Task task=new Task();
        task= taskService.createTask(task);

        Assert.assertEquals(3, taskService.findAllTasks().size());
        taskService.deleteTask(task);
    }
    @Test
    public void testDeleteTask(){
        Task task=new Task();
        task= taskService.createTask(task);
        taskService.deleteTask(task);

        Assert.assertEquals(2,taskService.findAllTasks().size());
    }



}