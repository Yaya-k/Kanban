package com.telecom.kanban.service.impl;

import com.telecom.kanban.dao.TaskRepository;
import com.telecom.kanban.dao.TaskStatusRepository;
import com.telecom.kanban.dao.TaskTypeRepository;
import com.telecom.kanban.domain.ChangeLog;
import com.telecom.kanban.domain.Task;
import com.telecom.kanban.domain.TaskStatus;
import com.telecom.kanban.domain.TaskType;
import com.telecom.kanban.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskStatusRepository taskStatusRepository;
    @Autowired
    private TaskTypeRepository taskTypeRepository;
    @Autowired
    private TaskRepository taskRepository;


    @Override
    @Transactional(readOnly = true)
    public TaskStatus findTaskStatus(Long id) {

        return this.taskStatusRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public TaskType findTaskType(Long id) {

        return this.taskTypeRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Task> findAllTasks() {
        return this.taskRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Task findTask(Long id) {
        return this.taskRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Task moveRightTask(Task task) {
        task.getStatus().moveTaskStatus("Right");
        return this.taskRepository.save(task);
    }

    @Override
    @Transactional
    public Task moveLeftTask(Task task) {

        task.getStatus().moveTaskStatus("Left");
        return this.taskRepository.save(task);
    }

    @Override
    @Transactional
    public Task changeTasksStatus(Task task, TaskStatus targetStatus) {
        task = this.taskRepository.save(task);
        ChangeLog changeLog=new ChangeLog();
        changeLog.setOccured(LocalDateTime.now());
        changeLog.setSourceStatus(task.getStatus());
        changeLog.setTargetStatus(targetStatus);
        task.addChangeLog(changeLog);
        task.setStatus(targetStatus);

        return task;
    }


    @Override
    @Transactional
    public Task createTask(Task task) {

        return this.taskRepository.save(task);
    }

    @Override
    @Transactional
    public void deleteTask(Task task) {
        this.taskRepository.delete(task);
    }

    @Override
    @Transactional(readOnly = true)

    public Collection<TaskType> findAllTaskType() {
        return this.taskTypeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<TaskStatus> findAllTaskStatus() {
        return this.taskStatusRepository.findAll();
    }

    @Override
    @Transactional
    public Collection<ChangeLog> findChangeLogsForTask(Task task) {
        task=this.taskRepository.save(task);
        return task.getChangeLogs();
    }
}
