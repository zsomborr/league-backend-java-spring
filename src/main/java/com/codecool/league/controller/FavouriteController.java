package com.codecool.league.controller;

import com.codecool.league.dto.UserFavouriteChampionDto;
import com.codecool.league.service.FavouriteService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class FavouriteController {

    private final FavouriteService favouriteService;
    private final Gson gson;

    @Autowired
    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
        this.gson = new Gson();
    }

    @PostMapping("/update-favourite")
    public Boolean updateUser(@RequestBody UserFavouriteChampionDto userFavouriteChampionDto) {
        return favouriteService.updateFavouriteChampions(userFavouriteChampionDto);
    }

    @PostMapping("/favourites")
    public String getFavourites(@RequestBody String email) {
        return gson.toJson(favouriteService.getFavouriteChampionsForUser(email));
    }

    @PostMapping("/champions")
    public String getAllChampionsWithFavouriteField(@RequestBody String email) {
        return gson.toJson(favouriteService.getAllChampionsWithFavouriteField(email));
    }

    @PostMapping("/champions/{tag}")
    public String getFilteredChampionsWithFavouriteField(@RequestBody String email, @PathVariable String tag) {
        return gson.toJson(favouriteService.getFilteredChampionsWithFavouriteField(email, tag));
    }
}
