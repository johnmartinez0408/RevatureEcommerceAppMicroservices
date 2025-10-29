package com.example.auth.service.controller;

import com.example.auth.service.entity.Role;
import com.example.auth.service.payload.LoginDto;
import com.example.auth.service.payload.RegisterDto;
import com.example.auth.service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/")
    public String index(){
        return "GET: Hello world!";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String message = authService.register(registerDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String message = authService.login(loginDto);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/role/{roleName}")
    public ResponseEntity<Role> getRole(@PathVariable String roleName){
        return new ResponseEntity<>(authService.getRoleByName(roleName), HttpStatus.OK);
    }
}
