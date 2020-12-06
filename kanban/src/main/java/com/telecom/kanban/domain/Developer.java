package com.telecom.kanban.domain;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Developer {

    private @Id long id;

    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private LocalDate startContract;

    @ManyToMany(fetch= FetchType.EAGER)
    private Set<Task> tasks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getStartContract() {
        return startContract;
    }

    public void setStartContract(LocalDate startContract) {
        this.startContract = startContract;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }


    public Developer() {

        this.tasks = new HashSet<>();

    }


}
