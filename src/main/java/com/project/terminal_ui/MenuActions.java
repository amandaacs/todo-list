package com.project.terminal_ui;

import com.project.model.Priority;
import com.project.model.Status;
import com.project.model.Task;
import com.project.service.TaskService;
import com.project.util.DateUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MenuActions {

    private final TaskService taskService;

    public MenuActions(TaskService taskService) {
        this.taskService = taskService;
    }

    public void createTask(Scanner scanner){
        System.out.print("Nome: ");
        String name = scanner.nextLine();

        System.out.print("Descrição: ");
        String description = scanner.nextLine();

        System.out.print("Data de término (yyyy-MM-dd): ");
        LocalDate dueDate = DateUtils.parseDate(scanner.nextLine());

        System.out.print("Prioridade (ONE, TWO, THREE, FOUR, FIVE): ");
        Priority priority = Priority.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Categoria: ");
        String category = scanner.nextLine();

        System.out.print("Status (TODO, DOING, DONE): ");
        Status status = Status.valueOf(scanner.nextLine().toUpperCase());

        Task task = new Task(
                name,
                description,
                dueDate,
                priority,
                category,
                status
        );

        taskService.add(task);
        System.out.println("Task criada com sucesso!");
    }

    private void listTasks(List<Task> tasks) {
        if(tasks.isEmpty()){
            System.out.println("Nenhuma task encontrada!");
            return;
        }

        int index = 0;
        for(Task task : tasks){
            System.out.println(index++ + " - " + task);
        }
    }

    public void listAllTasks() {
        listTasks(taskService.listAll());
    }

    public void listByCategory(Scanner scanner) {
        System.out.print("Categoria: ");
        String category = scanner.nextLine();
        listTasks(taskService.listByCategory(category));
    }

    public void listByPriority(Scanner scanner) {
        System.out.print("Prioridade (ONE, TWO, THREE, FOUR, FIVE):");
        Priority priority = Priority.valueOf(scanner.nextLine().toUpperCase());
        listTasks(taskService.listByPriority(priority));
    }

    public void listByStatus(Scanner scanner) {
        System.out.print("Status (TODO, DOING, DONE): ");
        Status status = Status.valueOf(scanner.nextLine().toUpperCase());
        listTasks(taskService.listByStatus(status));
    }

    public void listByDate(Scanner scanner) {
        System.out.print("Data limite (yyyy-MM-dd): ");
        LocalDate dueDate = DateUtils.parseDate(scanner.nextLine());
        listTasks(taskService.listByDate(dueDate));
    }

    public void updateTask(Scanner scanner) {
        List<Task> tasks = taskService.listAll();

        if(tasks.isEmpty()){
            System.out.println("Nenhuma task encontrada!");
            return;
        }

        listTasks(tasks);

        System.out.println("Digite o indice da task");
        int index = Integer.parseInt(scanner.nextLine());

        if(index < 0 || index >= tasks.size()){
            System.out.println("Indice invalido!");
            return;
        }

        System.out.print("Novo nome: ");
        String name = scanner.nextLine();

        System.out.print("Nova descrição: ");
        String description = scanner.nextLine();

        System.out.print("Nova data de término (yyyy-MM-dd): ");
        LocalDate dueDate = DateUtils.parseDate(scanner.nextLine());

        System.out.print("Nova prioridade (ONE, TWO, THREE, FOUR, FIVE): ");
        Priority priority = Priority.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Nova categoria: ");
        String category = scanner.nextLine();

        System.out.print("Novo status (TODO, DOING, DONE): ");
        Status status = Status.valueOf(scanner.nextLine().toUpperCase());

        Task updatedTask = new Task(
                name,
                description,
                dueDate,
                priority,
                category,
                status
        );

        taskService.update(index, updatedTask);
        System.out.println("Tarefa atualizada com sucesso!");
    }

    public void showStatusCount() {
        System.out.println("Status das tarefas:");
        System.out.println("TODO  : " + taskService.countByStatus(Status.TODO));
        System.out.println("DOING : " + taskService.countByStatus(Status.DOING));
        System.out.println("DONE  : " + taskService.countByStatus(Status.DONE));
    }
}
