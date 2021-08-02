package com.codecool.league.dao.fetch.championsDao;

import com.codecool.league.model.champions.ChampionModel;
import com.codecool.league.model.champions.ChampionsDataModel;
import com.codecool.league.util.Util;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@Component
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
        return new Gson().fromJson(championList , ChampionsDataModel.class);
    }

    @Override
    public ChampionsDataModel getChampionsByTag(String tag) {
        Map<String, ChampionModel> filteredChampions;
        ChampionsDataModel champions = new ChampionsDataModel();
        try {
            String championList = fetchChampions();
            champions = createChampions(championList);
            filteredChampions = champions.getData().entrySet().stream()
                    .filter(championModel -> championModel.getValue().getTags().contains(tag))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            champions.setData(filteredChampions);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return champions;
    }

    private String fetchChampions() throws IOException {
        return Util.getRiotApiJsonResponse(ENDPOINT);
    }
}
