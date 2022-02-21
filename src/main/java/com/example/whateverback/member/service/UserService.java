package com.example.whateverback.member.service;

import com.example.whateverback.auth.model.dto.JoinDTO;
import com.example.whateverback.member.model.entity.User;
import com.example.whateverback.member.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(JoinDTO joinDTO) {
        userRepository.save(joinDTO.toEntity());
    }

    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }
}
