package com.example.auth_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index(){
        return "GET: Hello world!";
    }

    @PostMapping("/")
    public String postIndex(){
        return "POST: Hello World!";
    }
}
