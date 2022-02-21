package com.example.whateverback.like.model.entity.service;

import com.example.whateverback.like.model.entity.dto.DibsDTO;
import com.example.whateverback.like.model.entity.repository.DibsRepository;
import com.example.whateverback.member.model.entity.User;
import com.example.whateverback.member.repository.UserRepository;
import com.example.whateverback.post.model.entity.Post;
import com.example.whateverback.post.model.entity.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DibsService {

    private final DibsRepository dibsRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public Boolean dibsPost(Long userId, Long jobId){

        Optional<User> user = userRepository.findById(userId);
        Optional<Post> post = postRepository.findById(jobId);

        DibsDTO dibsDTO = DibsDTO.builder()
                .userId(user.get())
                .postId(post.get())
                .build();

        dibsRepository.save(dibsDTO.toEntity());

        if(dibsRepository.findByUserIdAndPostId(user.get(), post.get()).isEmpty()){
            return false;
        } else {
            return true;
        }

    }

}
