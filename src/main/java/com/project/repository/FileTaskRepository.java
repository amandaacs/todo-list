package com.project.repository;

import com.project.model.Priority;
import com.project.model.Status;
import com.project.model.Task;
import com.project.util.FileUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileTaskRepository {

    private static final String FILE = "tasks.csv";

    public List<Task> load(){
        List<Task> tasks = new ArrayList<>();

        try(var reader = FileUtils.reader(FILE)){
            String line;
            while ((line = reader.readLine()) != null){
                String[] values = line.split(",");

                tasks.add(new Task(
                        values[0], values[1], LocalDate.parse(values[2]),
                        Priority.valueOf(values[3]),
                        values[4], Status.valueOf(values[5])
                ));
            }
        } catch (Exception ignored){}

        return tasks;
    }

    public void save(List<Task> tasks){
        try(var writer = FileUtils.writer(FILE)){
            for (Task task : tasks){
                writer.write(String.join(";",
                        task.getName(),
                        task.getDescription(),
                        task.getCategory(),
                        task.getDueDate().toString(),
                        task.getPriority().name(),
                        task.getCategory(),
                        task.getStatus().name()
                        ));
                writer.newLine();
            }
        } catch (Exception ignored){}

    }

}
