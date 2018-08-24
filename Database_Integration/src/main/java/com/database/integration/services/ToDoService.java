package com.database.integration.services;

import com.database.integration.models.ToDo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface ToDoService {

    List<ToDo> getAllTodos();

    List<ToDo> getActiveTodos(boolean active);

    void saveTodo(ToDo todo);

    void removeById(Long id);

    Optional<ToDo> getTodoById(Long id);

    void updateTodo(ToDo todo);
}