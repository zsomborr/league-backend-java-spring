package com.codecool.league.dao.championsDao;

import com.codecool.league.dao.championsDao.ChampionsDao;
import com.codecool.league.model.champions.ChampionsDataModel;
import com.codecool.league.model.champions.ChampionModel;
import com.codecool.league.util.Util;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ChampionsDaoFetch implements ChampionsDao {

    private final String ENDPOINT = "http://ddragon.leagueoflegends.com/cdn/11.10.1/data/en_US/champion.json";

    @Override
    public ChampionsDataModel getAllChampion() {
        try {
            String championList = fetchChampions();
            return createChampions(championList);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not fetch champions");
        }
    }

    private ChampionsDataModel createChampions(String championList) {
        ChampionsDataModel champions = new ChampionsDataModel();
        JSONObject championsJSON = new JSONObject(championList);
        var championsDataJSON = championsJSON.getJSONObject("data");
        Iterator<String> x = championsDataJSON.keys();
        JSONArray jsonArray = new JSONArray();
        while (x.hasNext()){
            String key = x.next();
            jsonArray.put(championsDataJSON.get(key));
            ChampionModel championModel = new  Gson().fromJson(championsDataJSON.get(key).toString(), ChampionModel.class);
            champions.putInSet(championModel);
        }
        return champions;
    }

    @Override
    public ChampionsDataModel getChampionsByTag(String tag) {
        Set<ChampionModel> filteredChampions;
        ChampionsDataModel champions = new ChampionsDataModel();
        try {
            String championList = fetchChampions();
            champions = createChampions(championList);
            filteredChampions = champions.getChampionModels().stream()
                    .filter(championModel -> championModel.getTags().contains(tag))
            .collect(Collectors.toSet());
            champions.setChampionModels(filteredChampions);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return champions;
    }

    private String fetchChampions() throws IOException {
        return Util.getRiotApiJsonResponse(ENDPOINT);
    }
}
