package com.example.whateverback.like.controller;

import com.example.whateverback.auth.config.JwtAuthenticationProvider;
import com.example.whateverback.like.service.DibsService;

import com.example.whateverback.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DibsController {

    private final DibsService dibsService;
    private final PostService postService;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    @PutMapping("/post/dibs/{jobId}")
    public ResponseEntity dibsPost(@PathVariable Long jobId, @RequestHeader(value = "X-AUTH-TOKEN") String token){

        postService.createPost(jobId);
        return new ResponseEntity(dibsService.dibsPost(Long.parseLong(jwtAuthenticationProvider.getUserPk(token)), jobId), HttpStatus.OK);

    }

}
