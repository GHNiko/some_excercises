package com.database.integration.services;

import com.database.integration.models.ToDo;
import com.database.integration.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService {

    private ToDoRepository todoRepository;

    @Autowired
    public ToDoServiceImpl(ToDoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<ToDo> getAllTodos() {
        List<ToDo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);
        return todos;
    }

    public List<ToDo> getActiveTodos(boolean active) {
        List<ToDo> todos = new ArrayList<>();
        if (active == true) {
            todoRepository.findByDoneFalse().forEach(todos::add);
        } else {
            todoRepository.findByDoneTrue().forEach(todos::add);
        }
        return todos;
    }

    public void saveTodo(ToDo todo) {
        todoRepository.save(todo);
    }

    public void removeById(Long id) {
        todoRepository.deleteById(id);
    }

    public Optional<ToDo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public void updateTodo(ToDo todo) {
        todoRepository.save(todo);
    }
}