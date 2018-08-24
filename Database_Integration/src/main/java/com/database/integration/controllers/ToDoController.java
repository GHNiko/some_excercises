package com.database.integration.controllers;


import com.database.integration.models.ToDo;
import com.database.integration.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ToDoController {

    private ToDoService todoService;

    @Autowired
    public ToDoController(ToDoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(value = {"/", "/list"})
    public String list(Model model) {
        model.addAttribute("todoslist", todoService.getAllTodos());
        return "todoslist";
    }

    @GetMapping(value = "/todo")
    public String listIsActive(@RequestParam(value = "isActive") boolean active, Model model) {
        model.addAttribute("todoslist", todoService.getActiveTodos(active));
        return "todoslist";
    }

    @GetMapping("/add")
    public String createTodo(Model model) {
        model.addAttribute("newTodo", new ToDo());
        return "createtodo";
    }

    @PostMapping("/create")
    public String saveTodo(@ModelAttribute ToDo todo) {
        todoService.saveTodo(todo);
        return "redirect:/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable(value = "id") Long id) {
        todoService.removeById(id);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String editTodo(@PathVariable(value = "id") Long id, Model model) {
        Optional<ToDo> todo = todoService.getTodoById(id);
        model.addAttribute("edittodo", todo.get());
        return "editpage";
    }

    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable(value = "id") Long id, @ModelAttribute ToDo todo) {
        todo.setId(id);
        todoService.updateTodo(todo);
        return "redirect:/list";
    }
}