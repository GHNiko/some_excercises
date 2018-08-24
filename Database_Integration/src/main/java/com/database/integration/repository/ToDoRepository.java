package com.database.integration.repository;

import com.database.integration.models.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {

    List<ToDo> findByDoneFalse();

    List<ToDo> findByDoneTrue();
}