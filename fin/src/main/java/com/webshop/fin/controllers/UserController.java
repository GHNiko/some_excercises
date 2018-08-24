package com.webshop.fin.controllers;

import com.webshop.fin.models.User;
import com.webshop.fin.repositories.UserRepository;
import com.webshop.fin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserService userService;

    @Autowired
    public UserController(UserRepository userRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @PutMapping("/api/:id")
    public void updateUser(@PathVariable long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping("/api/:id")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}