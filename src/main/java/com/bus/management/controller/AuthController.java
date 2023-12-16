package com.bus.management.controller;

import com.bus.management.entity.UserEntity;
import com.bus.management.security.JwtTokenProvider;
import com.bus.management.dto.UserDTO;
import com.bus.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private  JwtTokenProvider jwtTokenProvider;
    @Autowired
    private  UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody UserDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.createToken(loginRequest.getUsername());
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO signUpRequest) {
        UserEntity user = userService.registerUser(signUpRequest);
        return ResponseEntity.ok().body("User registered successfully");
    }

    private static class JwtAuthenticationResponse {
        private final String token;

        public JwtAuthenticationResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }
}

