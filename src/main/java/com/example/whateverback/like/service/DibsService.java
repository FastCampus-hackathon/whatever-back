package com.example.whateverback.like.service;

import com.example.whateverback.like.model.dto.DibsDTO;
import com.example.whateverback.like.repository.DibsRepository;
import com.example.whateverback.member.model.entity.User;
import com.example.whateverback.member.repository.UserRepository;
import com.example.whateverback.post.Repository.PostRepository;
import com.example.whateverback.post.model.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DibsService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final DibsRepository dibsRepository;

    @Transactional
    public Boolean dibsPost(Long userId, Long jobId){

        Optional<User> user = userRepository.findById(userId);
        Optional<Post> post = postRepository.findById(jobId);

        DibsDTO dibsDTO = DibsDTO.builder()
                .userId(user.get())
                .postId(post.get())
                .build();

        dibsRepository.save(dibsDTO.toEntity());

        if(dibsRepository.findByUserAndPost(user.get(), post.get()).isEmpty()){
            return false;
        } else {
            return true;
        }

    }

}
