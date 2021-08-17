package com.codecool.league.service;

import com.codecool.league.dao.fetch.championsDao.ChampionsDao;
import com.codecool.league.dao.fetch.freeChampionsDao.FreeChampionsDao;
import com.codecool.league.dao.repository.ChampionsRepository;
import com.codecool.league.model.champions.ChampionModel;
import com.codecool.league.model.champions.ChampionsDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ChampionsDatabaseSetupService {

    @Autowired
    private ChampionsRepository championRepository;

    private final ChampionsDao championsFetchService;
    private final FreeChampionsDao freeChampionsDao;

    private static final int DAY_IN_SECONDS = 86400000;

    @Autowired
    public ChampionsDatabaseSetupService(ChampionsDao championsDao, FreeChampionsDao freeChampionsDao) {
        this.championsFetchService = championsDao;
        this.freeChampionsDao = freeChampionsDao;
    }

    @Scheduled(fixedRate = DAY_IN_SECONDS)
    public void updateChampions() {
        ChampionsDataModel champions = championsFetchService.getAllChampion();
        Collection<ChampionModel> existingAndNewChampionsWithFreeData = mergeChampionsAndFreeData(champions).getData()
                .values();
        championRepository.saveAll(new ArrayList<>(existingAndNewChampionsWithFreeData));
    }

    private ChampionsDataModel mergeChampionsAndFreeData(ChampionsDataModel allChampion) {
        List<Integer> freeChampionIds = freeChampionsDao.getFreeChampions().getFreeChampionIds();
        allChampion.getData()
                .forEach((key, champion) -> champion.setFree(freeChampionIds.contains(Integer.parseInt(champion.getKey()))));
        return allChampion;
    }
}
