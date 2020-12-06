package com.telecom.kanban.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ChangeLog {
    private @Id
    long id;

    private LocalDateTime occured ;

    @ManyToOne
    private Task task;

    @OneToOne
    private TaskStatus sourceStatus;
    @OneToOne
    private TaskStatus targetStatus;

    public TaskStatus getSourceStatus() {
        return sourceStatus;
    }

    public void setSourceStatus(TaskStatus sourceStatus) {
        this.sourceStatus = sourceStatus;
    }

    public TaskStatus getTargetStatus() {
        return targetStatus;
    }

    public void setTargetStatus(TaskStatus targetStatus) {
        this.targetStatus = targetStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime  getOccured() {
        return occured;
    }

    public void setOccured(LocalDateTime  occured) {
        this.occured = occured;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
