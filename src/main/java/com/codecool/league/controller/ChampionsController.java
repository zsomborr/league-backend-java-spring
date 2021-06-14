package com.codecool.league.controller;

import com.codecool.league.service.ChampionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ChampionsController {

    private final ChampionsService championsService;

    @Autowired
    public ChampionsController(ChampionsService championsService) {
        this.championsService = championsService;
    }

    @GetMapping("/champions")
    public String getAllChampion() {
        return championsService.getAllChampion();
    }

    @GetMapping("/free")
    public String getFreeChampions() {
        return championsService.getFreeChampions();
    }

    @GetMapping("/champions/{tag}")
    public String getChampionsByTag(@PathVariable("tag") String tag) {
        return championsService.getChampionsByTag(tag);
        }
}
