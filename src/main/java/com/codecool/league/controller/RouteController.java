package com.codecool.league.controller;

import com.codecool.league.service.RiotApiService;
import com.codecool.league.Model.User;
import com.codecool.league.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class RouteController {

    private final RiotApiService riotApiService;
    private final UserService userService;

    @Autowired
    public RouteController(RiotApiService riotApiService, UserService userService) {
        this.riotApiService = riotApiService;
        this.userService = userService;
    }

    @GetMapping("/champions")
    public String getAllChampion() {
        return riotApiService.getAllChampion();
    }

    @GetMapping("/free")
    public String getFreeChampions() {
        return riotApiService.getFreeChampions();
    }

    @GetMapping("/user/{userName}")
    public String getUserInfo(@PathVariable("userName") String userName) {
        return riotApiService.getUserInfo(userName);
    }

    @GetMapping("/matches")
    public String getMatchHistory() {
        return riotApiService.getMatchHistory();
    }

    @GetMapping("/results")
    public String getMatchResults() {
        return riotApiService.getMatchDetails();
    }

    @GetMapping("/news")
    public String getNews() {return riotApiService.getNews();}

    @PostMapping("/login")
    public Boolean validateLogin(@RequestBody User user) {
        return userService.validateLogin(user);
    }

    @PostMapping("/register")
    public Boolean registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
}
