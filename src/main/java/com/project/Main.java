package com.project;

import com.project.repository.FileTaskRepository;
import com.project.repository.TaskRepository;
import com.project.service.TaskService;
import com.project.ui.MenuActions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println(" TODO List - Java Console ");
        System.out.println("=================================");

        Scanner scanner = new Scanner(System.in);

        TaskRepository taskRepository = new TaskRepository();

        FileTaskRepository fileTaskRepository = new FileTaskRepository();

        taskRepository.findAll().addAll(fileTaskRepository.load());

        TaskService taskService = new TaskService(taskRepository);

        MenuActions actions = new MenuActions(taskService);

        int opt;

        do{
            showMenu();
            opt = Integer.parseInt(scanner.nextLine());

            try {
                switch (opt) {
                    case 1 -> actions.createTask(scanner);
                    case 2 -> actions.listAllTasks();
                    case 3 -> actions.listByCategory(scanner);
                    case 4 -> actions.listByPriority(scanner);
                    case 5 -> actions.listByStatus(scanner);
                    case 6 -> actions.listByDate(scanner);
                    case 7 -> actions.updateTask(scanner);
                    case 8 -> actions.showStatusCount();
                    case 0 -> {
                        fileTaskRepository.save(taskRepository.findAll());
                        System.out.println("Tarefas salvas. Encerrando aplicação...");
                    }
                    default -> System.out.println("Opção inválida.");
                }
            } catch (Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opt != 0);

        scanner.close();
    }

    private static void showMenu(){
        System.out.println("\n--- MENU ---");
        System.out.println("1 - Criar tarefa");
        System.out.println("2 - Listar todas as tarefas");
        System.out.println("3 - Listar por categoria");
        System.out.println("4 - Listar por prioridade");
        System.out.println("5 - Listar por status");
        System.out.println("6 - Listar por data limite");
        System.out.println("7 - Atualizar tarefa");
        System.out.println("8 - Contagem por status");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int readOption(Scanner scanner) {
        try{
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            return -1;
        }
    }

}
