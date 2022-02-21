package com.example.whateverback.auth.controller;

import com.example.whateverback.auth.model.dto.JoinDTO;
import com.example.whateverback.auth.model.dto.LoginDTO;
import com.example.whateverback.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO, HttpServletResponse httpServletResponse) {
        String token = authService.login(loginDTO);
        httpServletResponse.addHeader("X-AUTH-TOKEN", token);
        return new ResponseEntity("login success", HttpStatus.OK);
    }

    @PostMapping("/join")
    public ResponseEntity join(@RequestBody JoinDTO joinDTO) {
        return new ResponseEntity(authService.join(joinDTO), HttpStatus.CREATED);
    }

    @GetMapping("/logout")
    public ResponseEntity logout(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("X-AUTH-TOKEN", null);
        authService.logout();
        return new ResponseEntity("logout success", HttpStatus.OK);
    }
}
