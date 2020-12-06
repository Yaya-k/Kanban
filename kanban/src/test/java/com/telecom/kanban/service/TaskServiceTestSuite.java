package com.telecom.kanban.service;

import com.telecom.kanban.domain.ChangeLog;
import com.telecom.kanban.domain.Task;
import com.telecom.kanban.domain.TaskStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")

public class TaskServiceTestSuite
{
    @Autowired
    private TaskService taskService;

    @Test
    public void testChangeTasksStatus(){
        Task task=new Task();
        TaskStatus doing = new TaskStatus(2L, "DOING");

        TaskStatus todo = new TaskStatus(1L, "TODO");
        task.setStatus(todo);
        task= taskService.changeTasksStatus(task,doing);

        Assert.assertEquals(task.getStatus().hashCode(),doing.hashCode());
        Assert.assertEquals(1,task.getChangeLogs().size());
        task.clearChangeLogs();
        Assert.assertEquals(0,task.getChangeLogs().size());

        taskService.deleteTask(task);

    }

    @Test
    public void testMoveRightTask() {
        Task task=new Task();
        TaskStatus todo = new TaskStatus(1L, "TODO");
        task.setStatus(todo);

        task= taskService.moveRightTask(task);

        Assert.assertEquals("DOING", task.getStatus().getLabel());
        taskService.deleteTask(task);
    }
    @Test
    public void testMoveLeftTask(){
        Task task=new Task();
        TaskStatus todo = new TaskStatus(1L, "DOING");
        task.setStatus(todo);

        task= taskService.moveLeftTask(task);

        Assert.assertEquals("TODO", task.getStatus().getLabel());
        taskService.deleteTask(task);
    }
    @Test
    public void testFindChangeLogsForTask(){
        Task task=new Task();
        TaskStatus todo = new TaskStatus(1L, "DOING");
        task.setStatus(todo);
        task.addChangeLog(new ChangeLog());



        Assert.assertEquals(1, taskService.findChangeLogsForTask(task).size());
        taskService.deleteTask(task);
    }


}