package com.project.bank.controller;

import com.project.bank.dao.User;
import com.project.bank.dto.NewUserDTO;
import com.project.bank.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody NewUserDTO user) {
        userService.saveUser(user);
        return ResponseEntity.ok("User created successfully");
    }
}
