package com.codecool.league.controller;

import com.codecool.league.service.RiotUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RiotUserController {

    private final RiotUserService riotUserService;

    @Autowired
    public RiotUserController(RiotUserService riotUserService) {
        this.riotUserService = riotUserService;
    }

    @GetMapping("/user/{userName}")
    public String getUserInfo(@PathVariable("userName") String userName) {
        return riotUserService.getUserInfo(userName);
    }

    @GetMapping("/matches")
    public String getMatchHistory() {
        return riotUserService.getMatchHistory();
    }

    @GetMapping("/results")
    public String getMatchResults() {
        return riotUserService.getMatchDetails();
    }

}
