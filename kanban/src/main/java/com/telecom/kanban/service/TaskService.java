package com.telecom.kanban.service;

import com.telecom.kanban.domain.ChangeLog;
import com.telecom.kanban.domain.Task;
import com.telecom.kanban.domain.TaskStatus;
import com.telecom.kanban.domain.TaskType;

import java.util.Collection;

public interface TaskService {
    public TaskStatus findTaskStatus(Long id);
    public TaskType findTaskType(Long id);
    public Collection<Task> findAllTasks();
    public Task findTask(Long id);
    public Task moveRightTask(Task task);
    public Task moveLeftTask(Task task);
    public Task changeTasksStatus(Task task, TaskStatus targetStatus);
    public Task createTask(Task task);
    public void deleteTask(Task task);
    public  Collection<TaskType> findAllTaskType();
    public  Collection<TaskStatus> findAllTaskStatus();
    public Collection<ChangeLog> findChangeLogsForTask(Task task);


}
