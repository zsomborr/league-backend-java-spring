package com.codecool.league.service;

import com.codecool.league.dao.championsDao.ChampionsDao;
import com.codecool.league.dao.freeChampionsDao.FreeChampionsDao;
import com.codecool.league.model.champions.ChampionModel;
import com.codecool.league.model.champions.ChampionsDataModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChampionsService {

    ChampionsDao championsDao;
    FreeChampionsDao freeChampionsDao;

    @Autowired
    public ChampionsService(ChampionsDao championsDao, FreeChampionsDao freeChampionsDao) {
        this.championsDao = championsDao;
        this.freeChampionsDao = freeChampionsDao;
    }

    public ChampionsDataModel getAllChampion() {
        List<Integer> freeChampionIds = freeChampionsDao.getFreeChampions().getFreeChampionIds();
//        championsDao.getAllChampion()
//                .getData()
//                .forEach((key, champion) -> {
//                    champion.setFree(freeChampionIds.contains(Integer.parseInt(champion.getKey())));
//                });
        ChampionsDataModel allChampion = championsDao.getAllChampion();
        allChampion
                .getData()
                .entrySet()
                .stream()
                .filter(champion -> freeChampionIds.contains(Integer.parseInt(champion.getValue().getKey())))
                .forEach(champion -> champion.getValue().setFree(true));

        return allChampion;
    }

    public ChampionsDataModel getChampionsByTag(String tag) {
        return championsDao.getChampionsByTag(tag);
    }

}
