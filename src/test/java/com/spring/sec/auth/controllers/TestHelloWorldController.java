package com.spring.sec.auth.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestHelloWorldController {

    @Autowired
    private MockMvc api;


    @Test
    void testHelloWorld() throws Exception {
        api.perform(MockMvcRequestBuilders.get("/api/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsStringIgnoringCase("Hello World")));
    }
}
