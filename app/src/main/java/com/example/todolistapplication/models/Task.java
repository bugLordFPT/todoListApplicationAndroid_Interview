package com.example.todolistapplication.models;

public class Task {
    private String id;
    private String name;
    private boolean isDone;


    public Task(String id, String name, boolean isDone){
        this.id = id;
        this.name = name;
        this.setDone(isDone);
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
