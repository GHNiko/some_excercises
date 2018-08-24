package com.webshop.fin.services;

import com.webshop.fin.models.User;
import com.webshop.fin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> findAllById(Long id) {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    public void updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).get();
        Assert.notNull(existingUser, "User not found");
        existingUser.setId(user.getId());
        userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        User userToDel = userRepository.findById(id).get();
        userRepository.delete(userToDel);
    }
}