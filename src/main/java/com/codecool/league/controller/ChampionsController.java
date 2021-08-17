package com.codecool.league.controller;

import com.codecool.league.model.champions.ChampionsDataModel;
import com.codecool.league.service.ChampionsService;
import com.codecool.league.model.champions.ChampionsIdAndKeyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/champions")
public class ChampionsController {

    private final ChampionsService championsService;

    @Autowired
    public ChampionsController(ChampionsService championsService) {
        this.championsService = championsService;
    }

    @GetMapping("")
    public ChampionsDataModel getAllChampion() {
        return championsService.getAllChampion();
    }

    @GetMapping("/userdata")
    public ChampionsIdAndKeyDataModel getAllChampionIdsAndKeys() {
        return championsService.getAllChampionIdsAndKeys();
    }

    @GetMapping("/{tag}")
    public ChampionsDataModel getChampionsByTag(@PathVariable("tag") String tag) {
        return championsService.getChampionsByTag(tag);
    }
}
