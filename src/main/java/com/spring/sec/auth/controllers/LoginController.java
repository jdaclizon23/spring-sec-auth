package com.spring.sec.auth.controllers;

import com.spring.sec.auth.model.LoginRequest;
import com.spring.sec.auth.model.LoginResponse;
import com.spring.sec.auth.security.JwtIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final JwtIssuer jwtIssuer;

    @PostMapping("/auth/login")
    public LoginResponse loginResponse(@RequestBody @Validated LoginRequest request){
        var token = jwtIssuer.issue(1L,request.getEmail(), List.of("USER"));
        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }
}
