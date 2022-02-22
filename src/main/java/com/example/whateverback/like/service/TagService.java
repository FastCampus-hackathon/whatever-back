package com.example.whateverback.like.service;

import com.example.whateverback.like.model.entity.Tag;
import com.example.whateverback.like.repository.TagRepository;
import com.example.whateverback.member.model.entity.User;
import com.example.whateverback.member.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;
    private final UserRepository userRepository;

    public Tag createTag(String name, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));
        return tagRepository.save(new Tag().builder()
                .name(name)
                .user(user)
                .build()
        );
    }
}
