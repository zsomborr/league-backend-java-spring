package com.codecool.league.controller;

import com.codecool.league.service.ChampionsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ChampionsController {

    private final ChampionsService championsService;
    private Gson gson;

    @Autowired
    public ChampionsController(ChampionsService championsService) {
        this.championsService = championsService;
        this.gson = new Gson();
    }

    @GetMapping("/champions")
    public String getAllChampion() {
        championsService.getAllChampion().getData().forEach((key, champion) -> {
            System.out.println(champion.isFree());
        });
        return gson.toJson(championsService.getAllChampion());
    }

//    @GetMapping("/free")
//    public String getFreeChampions() {
//        return championsService.getFreeChampions();
//    }

    @GetMapping("/champions/{tag}")
    public String getChampionsByTag(@PathVariable("tag") String tag) {
        return gson.toJson(championsService.getChampionsByTag(tag));
        }
}
