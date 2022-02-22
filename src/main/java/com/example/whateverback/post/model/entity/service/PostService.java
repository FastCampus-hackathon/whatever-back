package com.example.whateverback.post.model.entity.service;

import com.example.whateverback.post.model.entity.dto.PostDTO;
import com.example.whateverback.post.model.entity.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void createPost(Long jobId){
        PostDTO postDTO = PostDTO.builder()
                .id(jobId)
                .build();
        postRepository.save(postDTO.toEntity());
    }

}
