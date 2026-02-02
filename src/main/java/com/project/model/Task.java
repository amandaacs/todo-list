package com.project.model;

import java.time.LocalDate;

public class Task {

    private String name;
    private String description;
    private LocalDate dueDate;
    private Priority priority;
    private String category;
    private Status status;


    public Task(String name, String description, LocalDate dueDate, Priority priority, String category, Status status) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
        this.category = category;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public String getCategory() {
        return category;
    }


    @Override
    public String toString() {
        return
            "Nome: " + name + "\n" +
            "Descrição: " + description + "\n" +
            "Data de término: " + dueDate + "\n" +
            "Prioridade: " + priority + "\n" +
            "Categoria: " + category + "\n" +
            "Status: " + status;
    }
}
