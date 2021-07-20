package com.codecool.league.service;

import com.codecool.league.dao.repository.ChampionsRepository;
import com.codecool.league.model.champions.ChampionModel;
import com.codecool.league.model.champions.ChampionsDataModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ChampionsService {

    @Autowired
    private ChampionsRepository championsRepository;

    public ChampionsDataModel getAllChampion() {
        List<ChampionModel> championModels = championsRepository.findAll();

        return getChampionsDataModel(championModels);
    }

    public ChampionsDataModel getChampionsByTag(String tag) {
        List<ChampionModel> championModels = championsRepository.findAllByTags(tag);

        return getChampionsDataModel(championModels);
    }

    private ChampionsDataModel getChampionsDataModel(List<ChampionModel> championModels) {
        Map<String, ChampionModel> championsMap = championModels
                .stream()
                .collect(Collectors.toMap(
                        ChampionModel::getId,
                        Function.identity(),
                        (left, right) -> left,
                        LinkedHashMap::new)
                );
        var championsDataModel = new ChampionsDataModel();
        championsDataModel.setData(championsMap);

        return championsDataModel;
    }
}