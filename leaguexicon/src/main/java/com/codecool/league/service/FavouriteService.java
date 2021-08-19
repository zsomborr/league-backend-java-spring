package com.codecool.league.service;

import com.codecool.league.repository.ChampionsRepository;
import com.codecool.league.repository.UserRepository;
import com.codecool.league.model.champions.ChampionModel;
import com.codecool.league.model.champions.ChampionsDataModel;
import com.codecool.league.model.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class FavouriteService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChampionsRepository championsRepository;

    public Boolean updateFavouriteChampions(String username, String championId) {
        Optional<UserModel> userOptional = userRepository.findDistinctByUsername(username);
        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();
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
        return false;
    }

    public ChampionsDataModel getFavouriteChampionsForUser(String username) {
        List<String> favouriteChampionIds = getFavouriteChampionIds(username);
        List<ChampionModel> championModels = championsRepository.findAllByKeyIn(favouriteChampionIds);

        return getChampionsDataModel(favouriteChampionIds, championModels);
    }

    public ChampionsDataModel getAllChampionsWithFavouriteField(String username) {
        List<String> favouriteChampionIds = getFavouriteChampionIds(username);
        List<ChampionModel> championModels = championsRepository.findAll();

        return getChampionsDataModel(favouriteChampionIds, championModels);
    }

    public ChampionsDataModel getFilteredChampionsWithFavouriteField(String username, String tag) {
        List<String> favouriteChampionIds = getFavouriteChampionIds(username);
        List<ChampionModel> championModels = championsRepository.findAllByTags(tag);

        return getChampionsDataModel(favouriteChampionIds, championModels);
    }

    private ChampionsDataModel getChampionsDataModel(List<String> favouriteChampionIds, List<ChampionModel> championModels) {
        Map<String, ChampionModel> championsMap = championModels.stream()
                .collect(Collectors.toMap(
                        ChampionModel::getId,
                        Function.identity(),
                        (left, right) -> left,
                        LinkedHashMap::new));
        championsMap
                .forEach((key, champion) -> champion.setFavourite(favouriteChampionIds.contains(champion.getKey())));
        var championsDataModel = new ChampionsDataModel();
        championsDataModel.setData(championsMap);

        return championsDataModel;
    }

    private List<String> getFavouriteChampionIds(String username) {
        Optional<UserModel> userOptional = userRepository.findDistinctByUsername(username);
        if (userOptional.isPresent()) {
            return userOptional.get().getFavouriteChampionIds();
        }
        return new ArrayList<>();
    }
}