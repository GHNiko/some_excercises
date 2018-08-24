package com.reddit.app.services;


import com.reddit.app.models.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    List<Post> getAllPosts();
    void addPost(Post newPost);
}
