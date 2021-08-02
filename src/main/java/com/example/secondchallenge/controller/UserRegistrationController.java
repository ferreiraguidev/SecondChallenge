package com.example.secondchallenge.controller;

import com.example.secondchallenge.model.UserPostRequestBody;
import com.example.secondchallenge.persistence.Users;
import com.example.secondchallenge.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<Users> listAll() {
        return userService.ListAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<Users> save(@RequestBody UserPostRequestBody userPostRequestBody) {
        return new ResponseEntity<>(userService.save(userPostRequestBody), HttpStatus.CREATED);

    }
}
