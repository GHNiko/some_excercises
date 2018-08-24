package com.webshop.fin.repositories;

import com.webshop.fin.models.User;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    List<User> findAllById(Long id);
    User findUserById(Long Id);
}