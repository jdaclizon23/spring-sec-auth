package com.spring.sec.auth.controllers;

import com.spring.sec.auth.requests.LoginRequest;
import com.spring.sec.auth.model.LoginResponse;
import com.spring.sec.auth.security.JwtIssuer;
import com.spring.sec.auth.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final JwtIssuer jwtIssuer;

    private final AuthenticationManager authenticationManager;

    @PostMapping("/auth/login")
    public LoginResponse loginResponse(@RequestBody @Validated LoginRequest request){
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        //get the context of the security from the generated from the successful logged in
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //extract the principal which is the valid user that has been logged in
        var principal = (UserPrincipal)authentication.getPrincipal(); //casting into UserPrincipal

        //mapping all the user roles into principal authorities.
        var roles = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        var token = jwtIssuer.issue(principal.getId(),principal.getEmail(),roles);
        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }
}
