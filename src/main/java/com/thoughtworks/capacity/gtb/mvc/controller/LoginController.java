package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.model.exception.LoginRequestException;
import com.thoughtworks.capacity.gtb.mvc.service.LoginService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody User user) {
        loginService.register(user);
        return ResponseEntity.created(URI.create("")).build();
    }

    @GetMapping("/login")
    public ResponseEntity<User> login(@Valid String username, @RequestParam String password) {
        return ResponseEntity.ok(loginService.login(username, password));
    }
}
