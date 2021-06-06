package com.codecool.league.controller;

import com.codecool.league.service.RiotApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class RiotApiController {

    private final RiotApiService riotApiService;

    @Autowired
    public RiotApiController(RiotApiService riotApiService) {
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

    @GetMapping("/matches")
    public String getMatchHistory() {
        return riotApiService.getMatchHistory();
    }

    @GetMapping("/results")
    public String getMatchResults() {
        return riotApiService.getMatchDetails();
    }

    @GetMapping("/news/{pageNumber}")
    public String getNews(@PathVariable("pageNumber") int pageNumber) {return riotApiService.getNews(pageNumber);}
}
