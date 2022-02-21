package com.example.whateverback.auth.model.dto;

import com.example.whateverback.member.model.entity.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;

@Getter
public class JoinDTO {

    private Long id;
    private String userId;
    private String password;
    private List<String> roles = Collections.singletonList("ROLE_USER");

    @Builder
    @JsonCreator
    public JoinDTO(
            @JsonProperty("userId") String userId,
            @JsonProperty("password") String password) {
        this.userId = userId;
        this.password = password;
    }

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }

    public User toEntity() {
        return User.builder()
                .id(this.id)
                .userId(this.userId)
                .password(this.password)
                .roles(this.roles)
                .build();
    }
}
