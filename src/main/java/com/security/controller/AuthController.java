package com.security.controller;

import com.security.dto.UserReqDto;
import com.security.entity.User;

import com.security.service.UserService;
import com.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestBody UserReqDto userReqDto){

        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userReqDto.getUsername(),
                        userReqDto.getPassword()
                )
        );

        return jwtUtil.generateToken(userReqDto.getUsername());
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
         System.out.println(user.getUsername());
        User userData=  userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userData);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}

