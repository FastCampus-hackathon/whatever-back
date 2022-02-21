package com.example.whateverback.auth.controller;

import com.example.whateverback.auth.model.dto.JoinDTO;
import com.example.whateverback.auth.model.dto.LoginDTO;
import com.example.whateverback.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @RequestMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO, HttpServletResponse httpServletResponse) {
        String token = authService.login(loginDTO);
        httpServletResponse.addHeader("X-AUTH-TOKEN", authService.login(loginDTO));
        return new ResponseEntity(authService.login(loginDTO), HttpStatus.OK);
    }

    @RequestMapping("/join")
    public ResponseEntity join(@RequestBody JoinDTO joinDTO) {
        return new ResponseEntity(authService.join(joinDTO), HttpStatus.CREATED);
    }
}
