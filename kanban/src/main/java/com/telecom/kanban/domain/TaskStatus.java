package com.telecom.kanban.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaskStatus {
    private @Id
    Long id;
    private String label;
    public TaskStatus(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public TaskStatus() {
    }
    public void moveTaskStatus(String direction){
        if(direction.equals("Right")){
            switch (this.getLabel()){
                case "TODO":
                    this.setLabel("DOING");
                    break;
                case "DOING":
                    this.setLabel("TEST");
                    break;
                case "TEST":
                    this.setLabel("DONE");
                    break;
                default:
                    break;
            }
        }else if(direction.equals("Left")){
            switch (this.getLabel()){
                case "DONE":
                    this.setLabel("TEST");
                    break;
                case "TEST":
                    this.setLabel("DOING");
                    break;
                case "DOING":
                    this.setLabel("TODO");
                    break;
                default:
                    break;
        }

    }
}
}
