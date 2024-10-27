package com.spring.sec.auth.controllers;

import lombok.RequiredArgsConstructor;
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
    public String secured(){
        return "If you see this, then you're logged in";
    }
}
