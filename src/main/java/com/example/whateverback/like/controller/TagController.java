package com.example.whateverback.like.controller;

import com.example.whateverback.auth.config.JwtAuthenticationProvider;
import com.example.whateverback.like.service.TagService;
import com.example.whateverback.member.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    @PostMapping("/tag")
    public ResponseEntity createTage(@RequestBody String name, @RequestHeader("X-AUTH-TOKEN") String token) {
        Long userId = Long.parseLong(jwtAuthenticationProvider.getUserPk(token));
        return ResponseEntity.ok(tagService.createTag(name, userId));
    }
}
