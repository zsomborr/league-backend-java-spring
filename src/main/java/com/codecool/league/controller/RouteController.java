package com.codecool.league.controller;

import com.codecool.league.service.RiotApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
