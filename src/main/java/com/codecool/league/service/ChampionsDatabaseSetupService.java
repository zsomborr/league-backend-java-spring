package com.codecool.league.service;

import com.codecool.league.dao.fetch.championsDao.ChampionsDao;
import com.codecool.league.dao.fetch.freeChampionsDao.FreeChampionsDao;
import com.codecool.league.dao.repository.ChampionsRepository;
import com.codecool.league.model.champions.ChampionsDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

public class ChampionsDatabaseSetupService {

    @Autowired
    private ChampionsRepository championsRepository;

    private final ChampionsDao championsDao;
    private final FreeChampionsDao freeChampionsDao;

    private final int DAY_IN_SECONDS = 86400000;

    @Autowired
    public ChampionsDatabaseSetupService(ChampionsDao championsDao, FreeChampionsDao freeChampionsDao) {
        this.championsDao = championsDao;
        this.freeChampionsDao = freeChampionsDao;
    }

    @Scheduled(fixedRate = DAY_IN_SECONDS)
    public void updateChampions() {
        ChampionsDataModel champions = championsDao.getAllChampion();
        championsRepository.saveAll(new ArrayList<>(mergeChampionsAndFreeData(champions).getData()
                .values()));
    }

    private ChampionsDataModel mergeChampionsAndFreeData(ChampionsDataModel allChampion) {
        List<Integer> freeChampionIds = freeChampionsDao.getFreeChampions().getFreeChampionIds();
        allChampion.getData()
                .forEach((key, champion) -> champion.setFree(freeChampionIds.contains(Integer.parseInt(champion.getKey()))));
        return allChampion;
    }
}
