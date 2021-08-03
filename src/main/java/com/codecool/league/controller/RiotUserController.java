package com.codecool.league.controller;

import com.codecool.league.model.riotUser.RiotUserDetailModel;
import com.codecool.league.model.riotUser.matchHistory.MatchModel;
import com.codecool.league.model.riotUser.matchResults.MatchResultModel;
import com.codecool.league.service.RiotUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/riot")
public class RiotUserController {

    private final RiotUserService riotUserService;

    @Autowired
    public RiotUserController(RiotUserService riotUserService) {
        this.riotUserService = riotUserService;
    }

    @GetMapping("/{userName}")
    public RiotUserDetailModel getUserInfo(@PathVariable("userName") String userName) {
        return riotUserService.getUserInfo(userName);
    }

    @GetMapping("/matches")
    public List<MatchModel> getMatchHistory() {
        return riotUserService.getMatchHistory();
    }

    @GetMapping("/results")
    public List<MatchResultModel> getMatchResults() {
        return riotUserService.getMatchDetails();
    }

}
