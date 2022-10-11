package com.example.jwt.demo.controllers;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.demo.models.LoginRequest;
import com.example.jwt.demo.services.TokenService;

@RestController
public class AuthController {
    private Logger logger = Logger.getLogger(AuthController.class.getName());

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping(path = "/token")
    public ResponseEntity<String> token(@RequestBody LoginRequest loginRequest) {
        logger.info("token requested for user: " + loginRequest.username());
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username(),
                        loginRequest.password()));
        String token = tokenService.generateToken(auth);
        logger.info("token granted: " + token);
        return ResponseEntity.ok(token);
    }

}
