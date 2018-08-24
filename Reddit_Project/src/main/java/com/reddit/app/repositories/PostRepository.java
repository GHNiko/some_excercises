package com.reddit.app.repositories;

import com.reddit.app.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}