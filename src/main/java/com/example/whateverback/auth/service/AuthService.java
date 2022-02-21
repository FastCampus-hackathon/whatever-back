package com.example.whateverback.auth.service;

import com.example.whateverback.auth.config.JwtAuthenticationProvider;
import com.example.whateverback.auth.model.dto.JoinDTO;
import com.example.whateverback.auth.model.dto.LoginDTO;
import com.example.whateverback.member.model.entity.User;
import com.example.whateverback.member.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public void join(JoinDTO joinDTO) {
        joinDTO.encodePassword(passwordEncoder);
        userService.saveUser(joinDTO);;
    }

    public String login(LoginDTO loginDTO) {
        User user = userService.findByUserId(loginDTO.getUserId());
        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }
        return jwtAuthenticationProvider.createToken(String.valueOf(user.getId()), user.getRoles());
    }

    public void logout() {
        SecurityContextHolder.clearContext();
    }
}
