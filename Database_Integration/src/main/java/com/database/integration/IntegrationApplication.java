package com.database.integration;

import com.database.integration.models.ToDo;
import com.database.integration.repository.ToDoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntegrationApplication implements CommandLineRunner {

    private
    ToDoRepository todoRepository;

    public IntegrationApplication(ToDoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(IntegrationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        todoRepository.save(new ToDo("daily task", false, false));
        todoRepository.save(new ToDo("make the beds", true, true));
        todoRepository.save(new ToDo("do the washing up", true, false));
        todoRepository.save(new ToDo("clean the bathroom and the kitchen.", true, true));
        todoRepository.save(new ToDo("sweep the floor", true, true));
        todoRepository.save(new ToDo("wash the floors", true, false));
        todoRepository.save(new ToDo("vacuum the carpet", false, false));
        todoRepository.save(new ToDo("dust the furniture", false, true));
        todoRepository.save(new ToDo("tidy up", false, true));
    }
}
