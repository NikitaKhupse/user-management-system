package com.nikita.usermanagement.controller;

import com.nikita.usermanagement.dto.LoginRequest;
import com.nikita.usermanagement.entity.User;
import com.nikita.usermanagement.repository.UserRepository;
import com.nikita.usermanagement.security.JwtService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder encoder;

    public AuthController(UserRepository userRepository,
                          JwtService jwtService,
                          BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.encoder = encoder;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (encoder.matches(request.getPassword(), user.getPassword())) {
            return jwtService.generateToken(user.getEmail());
        }

        throw new RuntimeException("Invalid password");
    }
}