package com.codecool.league.controller;

import com.codecool.league.service.ChampionsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ChampionsController {

    private final ChampionsService championsService;
    private final Gson gson;

    @Autowired
    public ChampionsController(ChampionsService championsService) {
        this.championsService = championsService;
        this.gson = new Gson();
    }

    @GetMapping("/champions")
    public String getAllChampion() {
        return gson.toJson(championsService.getAllChampion());
    }

    @GetMapping("/champions/{tag}")
    public String getChampionsByTag(@PathVariable("tag") String tag) {
        return gson.toJson(championsService.getChampionsByTag(tag));
    }
}
