package com.spring.sec.auth.controllers;

import com.spring.sec.auth.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/secured")
    public String secured(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return "If you see this, then you're logged in as user " + userPrincipal.getEmail()+ " id: " + userPrincipal.getId();
//        return "If you see this, then you're logged in as user";
    }
}
