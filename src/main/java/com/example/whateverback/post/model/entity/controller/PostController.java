package com.example.whateverback.post.model.entity.controller;

import com.example.whateverback.ApiTest.ApiService;
import com.example.whateverback.post.model.entity.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/getApi2")
    public ResponseEntity<Map> getPost(){
        return postService.requestPost();
    }

}
