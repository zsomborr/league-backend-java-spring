package com.codecool.league.service;

import com.codecool.league.dao.ChampionsDao;
import com.codecool.league.dao.FreeChampionsDao;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

public class ChampionsService {

    ChampionsDao championsDao;
    FreeChampionsDao freeChampionsDao;
    Gson gson;


    @Autowired
    public ChampionsService(ChampionsDao championsDao, FreeChampionsDao freeChampionsDao) {
        this.championsDao = championsDao;
        this.freeChampionsDao = freeChampionsDao;
        this.gson = new Gson();
    }

    public String getAllChampion() {
        return gson.toJson(championsDao.getAllChampion());
    }

    public String getFreeChampions() {
        return gson.toJson(freeChampionsDao.getFreeChampions().getFreeChampionIds());
    }

}
