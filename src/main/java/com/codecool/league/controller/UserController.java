package com.codecool.league.controller;

import com.codecool.league.dto.UserDto;
import com.codecool.league.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity validateLogin(@RequestBody UserDto userDto) {
        return userService.validateLogin(userDto);
    }

    @PostMapping("/register")
    public Boolean registerUser(@RequestBody UserDto userDto) {
        return userService.registerUser(userDto);
    }
}
