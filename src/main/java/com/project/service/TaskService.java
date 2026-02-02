package com.project.service;

import com.project.model.Priority;
import com.project.model.Status;
import com.project.model.Task;
import com.project.repository.TaskRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    private void reorder(){
        repository.findAll().sort(
                Comparator.comparingInt(t -> t.getPriority().getLevel())
        );
    }

    public void add(Task task) {
        repository.save(task);
        reorder();
    }


    public void update(int index, Task task) {
        repository.findAll().set(index, task);
        reorder();
    }

    public List<Task> listAll() {
        return repository.findAll();
    }

    public List<Task> listByCategory(String category) {
        return repository.findAll().stream()
                .filter(t -> t.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Task> listByStatus(Status status) {
        return repository.findAll().stream()
                .filter(t -> t.getStatus() == status)
                .collect(Collectors.toList());
    }

    public List<Task> listByPriority(Priority priority) {
        return repository.findAll().stream()
                .filter(t -> t.getPriority() == priority)
                .collect(Collectors.toList());
    }

    public List<Task> listByDate(LocalDate date) {
        return repository.findAll().stream()
                .filter(t -> !t.getDueDate().isAfter(date))
                .collect(Collectors.toList());
    }

    public Long countByStatus(Status status) {
        return repository.findAll().stream()
                .filter(t -> t.getStatus() == status)
                .count();
    }

}
