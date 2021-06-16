package com.codecool.league.controller;

import com.codecool.league.service.RiotUserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/riot")
public class RiotUserController {

    private final RiotUserService riotUserService;
    private final Gson gson;

    @Autowired
    public RiotUserController(RiotUserService riotUserService) {
        this.riotUserService = riotUserService;
        this.gson = new Gson();
    }

    @GetMapping("/{userName}")
    public String getUserInfo(@PathVariable("userName") String userName) {
        return gson.toJson(riotUserService.getUserInfo(userName));
    }

    @GetMapping("/matches")
    public String getMatchHistory() {
        return gson.toJson(riotUserService.getMatchHistory());
    }

    @GetMapping("/results")
    public String getMatchResults() {
        return gson.toJson(riotUserService.getMatchDetails());
    }

}
