package com.codecool.league.service;

import com.codecool.league.dao.repository.ChampionsRepository;
import com.codecool.league.dao.repository.UserRepository;
import com.codecool.league.dto.UserFavouriteChampionDto;
import com.codecool.league.model.champions.ChampionModel;
import com.codecool.league.model.champions.ChampionsDataModel;
import com.codecool.league.model.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FavouriteService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChampionsRepository championsRepository;

    public Boolean updateFavouriteChampions(UserFavouriteChampionDto userFavouriteChampionDto) {
        String email = userFavouriteChampionDto.getEmail();
        String championId = userFavouriteChampionDto.getChampionId();
        UserModel user = userRepository.findDistinctByEmail(email);
        List<String> favouriteChampionIds = user.getFavouriteChampionIds();

        if (favouriteChampionIds.contains(championId)) {
            favouriteChampionIds.remove(championId);
            System.out.println("Removed item");
        } else {
            favouriteChampionIds.add(championId);
            System.out.println("Added item");
        }

        user.setFavouriteChampionIds(favouriteChampionIds);
        userRepository.save(user);
        return true;
    }

    public ChampionsDataModel getFavouriteChampionsForUser(String email) {
        UserModel user = userRepository.findDistinctByEmail(email);
        List<String> favouriteChampionIds = user.getFavouriteChampionIds();
        List<ChampionModel> championModels = championsRepository.findAllByKeyIn(favouriteChampionIds);

        Map<String, ChampionModel> championsMap = championModels.stream()
                .collect(Collectors.toMap(ChampionModel::getId, Function.identity()));
        var championsDataModel = new ChampionsDataModel();
        championsDataModel.setData(championsMap);
        return championsDataModel;
    }

    public ChampionsDataModel getAllChampionsWithFavouriteField(String email) {
        List<ChampionModel> championModels = championsRepository.findAll();
        return getChampionsDataModel(email, championModels);
    }

    public ChampionsDataModel getFilteredChampionsWithFavouriteField(String email, String tag) {
        List<ChampionModel> championModels = championsRepository.findAllByTags(tag);
        return getChampionsDataModel(email, championModels);
    }

    private ChampionsDataModel getChampionsDataModel(String email, List<ChampionModel> championModels) {
        UserModel user = userRepository.findDistinctByEmail(email);
        List<String> favouriteChampionIds = user.getFavouriteChampionIds();

        Map<String, ChampionModel> championsMap = championModels.stream()
                .collect(Collectors.toMap(ChampionModel::getId, Function.identity()));

        championsMap
                .forEach((key, champion) -> champion.setFavourite(favouriteChampionIds.contains(champion.getKey())));
        var championsDataModel = new ChampionsDataModel();
        championsDataModel.setData(championsMap);
        return championsDataModel;
    }
}