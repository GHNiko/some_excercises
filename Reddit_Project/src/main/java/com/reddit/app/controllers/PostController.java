package com.reddit.app.controllers;

import com.reddit.app.models.Post;
import com.reddit.app.models.Posts;
import com.reddit.app.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public Posts getPostList() {
        return new Posts(postService.getAllPosts());
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post newPost) {
        postService.addPost(newPost);
        return newPost;
    }

}