package com.codecool.league.dao;


import com.codecool.league.model.champions.ChampionsModel;
import com.codecool.league.model.championsListTest.ChampionModel;
import com.codecool.league.util.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChampionsDaoFetch implements ChampionsDao {

    @Override
    public ChampionsModel getAllChampion() {
        ChampionsModel champions = null;
        try {
            String championList = Util.getRiotApiJsonResponse("http://ddragon.leagueoflegends.com/cdn/11.10.1/data/en_US/champion.json");
//            Type championListType = new TypeToken<Data>(){}.getType();
            champions = new Gson().fromJson(championList, ChampionsModel.class);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return champions;
    }

    @Override
    public List<ChampionModel>  getChampionsByTag(String tag) {
        List<ChampionModel> filteredChampions = new ArrayList<>();
        try {
            String championList = Util.getRiotApiJsonResponse("http://ddragon.leagueoflegends.com/cdn/11.10.1/data/en_US/champion.json");
            Type championListType = new TypeToken<ArrayList<ChampionModel>>(){}.getType();
            ArrayList<ChampionModel> champions = new Gson().fromJson(championList, championListType);
            filteredChampions = champions.stream()
                    .filter(championModel -> championModel.getTags().contains(tag))
            .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filteredChampions;
    }
}
