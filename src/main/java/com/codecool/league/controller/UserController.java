package com.codecool.league.controller;

import com.codecool.league.Model.User;
import com.codecool.league.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Boolean validateLogin(@RequestBody User user) {
        return userService.validateLogin(user);
    }

    @PostMapping("/register")
    public Boolean registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
}
