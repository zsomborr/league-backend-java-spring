package com.codecool.league.controller;

import com.codecool.league.service.RiotApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {

    private final RiotApiService riotApiService;

    @Autowired
    public RouteController(RiotApiService riotApiService) {
        this.riotApiService = riotApiService;
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

}
