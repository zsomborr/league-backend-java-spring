package com.codecool.league.dao.fetch.freeChampionsDao;

import com.codecool.league.model.freeChampions.FreeChampionsModel;
import com.codecool.league.util.Util;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class FreeChampionsDaoFetch implements FreeChampionsDao {

    private final String FREE_CHAMPIONS_ENDPOINT = "https://eun1.api.riotgames.com/lol/platform/v3/champion-rotations";

    @Override
    public FreeChampionsModel getFreeChampions() {
        FreeChampionsModel freeChampions = null;
        try {
            String freeChampionsFromApi = Util.getRiotApiJsonResponse(FREE_CHAMPIONS_ENDPOINT);
            freeChampions = new Gson().fromJson(freeChampionsFromApi, FreeChampionsModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return freeChampions;
    }
}
