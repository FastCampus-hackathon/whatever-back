package com.example.whateverback.post.controller;

import com.example.whateverback.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public ResponseEntity getPosts() {
        String json = postService.getPosts();

        return ResponseEntity.ok(json);
    }

}
