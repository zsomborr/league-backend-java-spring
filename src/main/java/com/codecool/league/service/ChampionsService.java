package com.codecool.league.service;

import com.codecool.league.dao.repository.ChampionsRepository;
import com.codecool.league.model.champions.ChampionModel;
import com.codecool.league.model.champions.ChampionsDataModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ChampionsService {

    @Autowired
    private ChampionsRepository championsRepository;

    public ChampionsDataModel getAllChampion() {
        List<ChampionModel> championModels = championsRepository.findAll();
        Map<String, ChampionModel> championsMap = championModels.stream()
                .collect(Collectors.toMap(ChampionModel::getId, Function.identity()));
        var championsDataModel = new ChampionsDataModel();
        championsDataModel.setData(championsMap);
        return championsDataModel;
    }

    public ChampionsDataModel getChampionsByTag(String tag) {
        List<ChampionModel> championModels = championsRepository.findAllByTags(tag);
        Map<String, ChampionModel> championsMap = championModels.stream()
                .collect(Collectors.toMap(ChampionModel::getId, Function.identity()));
        var championsDataModel = new ChampionsDataModel();
        championsDataModel.setData(championsMap);
        return championsDataModel;
    }
}