package com.database.integration;

import com.database.integration.models.ToDo;
import com.database.integration.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntegrationApplication implements CommandLineRunner {

    private
    ToDoRepository todoRepository;

    @Autowired
    public IntegrationApplication(ToDoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(IntegrationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        todoRepository.save(new ToDo("Work", false, false));
        todoRepository.save(new ToDo("Practice", true, true));
        todoRepository.save(new ToDo("Working out", true, false));
        todoRepository.save(new ToDo("Clean", true, true));
    }
}
