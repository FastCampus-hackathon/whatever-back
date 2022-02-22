package com.example.whateverback.post.controller;

import com.example.whateverback.post.model.DTO.PostRequestDTO;
import com.example.whateverback.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public ResponseEntity getPosts(@RequestBody PostRequestDTO postRequestDTO) {
        String json = postService.getPosts(postRequestDTO);

        return ResponseEntity.ok(json);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity getPostById(@PathVariable("id") Long id) {
        String json = postService.getPostById(id);

        return ResponseEntity.ok(json);
    }

}
