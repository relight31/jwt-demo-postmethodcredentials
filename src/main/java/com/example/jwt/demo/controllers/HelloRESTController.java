package com.example.jwt.demo.controllers;

import java.security.Principal;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController {
    @Secured("USER")
    @GetMapping(path = "/home")
    public String hello(Principal principal) {
        return "Hello " + principal.getName();
    }
}
