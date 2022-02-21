package com.example.whateverback.auth.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginDTO {

    private String userId;
    private String password;

    @Builder
    @JsonCreator
    public LoginDTO(
            @JsonProperty("userId") String userId,
            @JsonProperty("password") String password) {
        this.userId = userId;
        this.password = password;
    }

}
