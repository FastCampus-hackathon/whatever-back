package com.example.whateverback.member.service;

import com.example.whateverback.member.model.entity.User;
import com.example.whateverback.member.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String userId) {
        User user = userRepository.findById(Long.valueOf(userId)).get();

        if(user == null) throw new IllegalArgumentException("아이디가 존재하지 않습니다.");

        return user;
    }

}
