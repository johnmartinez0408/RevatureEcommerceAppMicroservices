package com.example.auth.service.service;

import com.example.auth.service.entity.Role;
import com.example.auth.service.payload.LoginDto;
import com.example.auth.service.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    Role getRoleByName(String roleName);
}
