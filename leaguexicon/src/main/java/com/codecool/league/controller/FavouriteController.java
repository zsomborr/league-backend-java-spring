package com.codecool.league.controller;

import com.codecool.league.model.champions.ChampionsDataModel;
import com.codecool.league.security.JwtTokenServices;
import com.codecool.league.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8762"})
@RestController
@RequestMapping("/lxn/user")
public class FavouriteController {

    private final FavouriteService favouriteService;
    private final JwtTokenServices jwtTokenServices;

    @Autowired
    public FavouriteController(FavouriteService favouriteService, JwtTokenServices jwtTokenServices) {
        this.favouriteService = favouriteService;
        this.jwtTokenServices = jwtTokenServices;
    }

    @PutMapping("/update-favourite")
    public Boolean updateUser(@RequestBody String championId, HttpServletRequest req) {
        String username = getUsernameFromRequest(req);
        return favouriteService.updateFavouriteChampions(username, championId);
    }

    @GetMapping("/favourites")
    public ChampionsDataModel getFavourites(HttpServletRequest req) {
        String username = getUsernameFromRequest(req);
        return favouriteService.getFavouriteChampionsForUser(username);
    }

    @GetMapping("/champions")
    public ChampionsDataModel getAllChampionsWithFavouriteField(HttpServletRequest req) {
        String username = getUsernameFromRequest(req);
        return favouriteService.getAllChampionsWithFavouriteField(username);
    }

    @GetMapping("/champions/{tag}")
    public ChampionsDataModel getFilteredChampionsWithFavouriteField(HttpServletRequest req, @PathVariable String tag) {
        String username = getUsernameFromRequest(req);
        return favouriteService.getFilteredChampionsWithFavouriteField(username, tag);
    }

    private String getUsernameFromRequest(HttpServletRequest req) {
        String token = jwtTokenServices.getTokenFromRequest(req);
        return jwtTokenServices.getUsernameFromToken(token);
    }
}
