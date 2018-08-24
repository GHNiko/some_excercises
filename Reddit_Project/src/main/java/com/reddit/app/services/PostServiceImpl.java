package com.reddit.app.services;


import com.reddit.app.models.Post;
import com.reddit.app.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public void addPost(Post newPost) {
        postRepository.save(newPost);
    }

}