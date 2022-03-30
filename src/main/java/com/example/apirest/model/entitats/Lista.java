package com.example.apirest.model.entitats;


import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Lista {

    @Id
    @GeneratedValue
    int id;
    String title;
    String color;

    @ManyToMany
    Set<Usuari> users;

    @OneToMany
    private List<Task> tasks;


    public Lista(int id, String title, String color, List<Task> tasks ) {
        super();
        this.id = id;
        this.title = title;
        this.color = color;
        this.tasks = tasks;
    }

    public Lista() {
        super();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
