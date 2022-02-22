package com.example.whateverback.like.service;

import com.example.whateverback.auth.config.JwtAuthenticationProvider;
import com.example.whateverback.like.model.dto.TaggingRequestDTO;
import com.example.whateverback.like.model.entity.Dibs;
import com.example.whateverback.like.model.entity.Tag;
import com.example.whateverback.like.model.entity.Tagging;
import com.example.whateverback.like.repository.DibsRepository;
import com.example.whateverback.like.repository.TagRepository;
import com.example.whateverback.like.repository.TaggingRepository;
import com.example.whateverback.member.repository.UserRepository;
import com.example.whateverback.post.Repository.PostRepository;
import com.example.whateverback.post.model.entity.Post;
import com.example.whateverback.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class TaggingService {

    private final TaggingRepository taggingRepository;
    private final PostRepository postRepository;
    private final TagRepository tagRepository;
    private final DibsRepository dibsRepository;

    @Transactional
    public void addTagging(TaggingRequestDTO taggingRequestDTO) {
        Post post = postRepository.findById(taggingRequestDTO.getPostId()).orElseThrow();
        Tag tag = tagRepository.findById(taggingRequestDTO.getTagId()).orElseThrow();
        Dibs dibs = dibsRepository.findByPost(post).orElseThrow();
        Tagging tagging = Tagging.builder()
                .post(post)
                .tag(tag)
                .dibs(dibs)
                .build();
        taggingRepository.save(tagging);
    }
}
