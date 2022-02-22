package com.example.whateverback.post.controller;

import com.example.whateverback.post.model.DTO.PostRequestDTO;
import com.example.whateverback.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity getPosts(@RequestBody PostRequestDTO postRequestDTO) {
        return new ResponseEntity(postService.getPosts(postRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity getPostById(@PathVariable("id") Long id) {
        String json = postService.getPostById(id);

        return new ResponseEntity(json, HttpStatus.OK);
    }

}
