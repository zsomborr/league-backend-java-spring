package com.codecool.league.service;

import com.codecool.league.dao.repository.ChampionsRepository;
import com.codecool.league.model.champions.ChampionModel;
import com.codecool.league.model.champions.ChampionsDataModel;
import com.codecool.league.model.champions.ChampionsIdAndKeyDataModel;
import com.codecool.league.model.champions.ChampionIdAndKeyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ChampionsService {

    @Autowired
    private ChampionsRepository championsRepository;

    public ChampionsDataModel getAllChampion() {
        List<ChampionModel> championModels = championsRepository.findAll();

        return getChampionsDataModel(championModels);
    }

    public ChampionsIdAndKeyDataModel getAllChampionIdsAndKeys() {
        List<ChampionModel> championModels = championsRepository.findAll();
        List<ChampionIdAndKeyModel> championIdDtos = championModels.stream().map(e -> ChampionIdAndKeyModel.builder()
                        .id(e.getId())
                        .key(e.getKey())
                        .build())
                .collect(Collectors.toList());
        return getChampionIdDtoMap(championIdDtos);
    }


    @Transactional
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

    private ChampionsIdAndKeyDataModel getChampionIdDtoMap(List<ChampionIdAndKeyModel> championIdDtos) {
        Map<String, ChampionIdAndKeyModel> championsMap = championIdDtos
                .stream()
                .collect(Collectors.toMap(
                        ChampionIdAndKeyModel::getId,
                        Function.identity(),
                        (left, right) -> left,
                        LinkedHashMap::new)
                );

        var championsIdAndKeyDataModel = new ChampionsIdAndKeyDataModel();
        championsIdAndKeyDataModel.setData(championsMap);

        return championsIdAndKeyDataModel;
    }
}