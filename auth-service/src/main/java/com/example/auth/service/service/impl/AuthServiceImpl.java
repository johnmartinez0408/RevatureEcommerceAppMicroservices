package com.example.auth.service.service.impl;

import com.example.auth.service.entity.Role;
import com.example.auth.service.entity.User;
import com.example.auth.service.payload.RegisterDto;
import com.example.auth.service.repository.RoleRepository;
import com.example.auth.service.repository.UserRepository;
import com.example.auth.service.security.JwtTokenProvider;
import com.example.auth.service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.example.auth.service.payload.LoginDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl  implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public String login(LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    loginDto.getUsernameOrEmail(),
                    loginDto.getPassword()
            )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }

    @Override
    public String register(RegisterDto registerDto) {
        //check if user exists in db
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new RuntimeException("Username is taken!");
        }
        //
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new RuntimeException("Email is taken!");
        }

        // new user object
        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        //Assign roles to user
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("USER")
                .orElseThrow(()-> new RuntimeException("User Role not set."));
//        Role userRole = getRoleByName("USER");
        roles.add(userRole);
        user.setRoles(roles);


        userRepository.save(user);

        return "User registered successfully!";
    }

    @Override
    public Role getRoleByName(String roleName) {
        Role role = roleRepository.findByName(roleName)
                .orElseThrow(()-> new RuntimeException("User Role not set."));
        return role;
    }
}
