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
        return mergeChampionsAndFreeData(championsDao.getAllChampion());
    }

    public ChampionsDataModel getChampionsByTag(String tag) {
        return mergeChampionsAndFreeData(championsDao.getChampionsByTag(tag));
    }

    private ChampionsDataModel mergeChampionsAndFreeData(ChampionsDataModel allChampion) {
        List<Integer> freeChampionIds = freeChampionsDao.getFreeChampions().getFreeChampionIds();
        allChampion.getData()
                .forEach((key, champion) -> {
                    champion.setFree(freeChampionIds.contains(Integer.parseInt(champion.getKey())));
                });
        return allChampion;
    }

}
