package com.codecool.league.dao.freeChampionsDao;

import com.codecool.league.model.freeChampions.FreeChampionsModel;
import com.codecool.league.util.Util;
import com.google.gson.Gson;

public class FreeChampionsDaoFetch implements FreeChampionsDao {
    @Override
    public FreeChampionsModel getFreeChampions() {
        FreeChampionsModel freeChampions = null;
        try {
            String freeChampionsFromApi = Util.getRiotApiJsonResponse("https://eun1.api.riotgames.com/lol/platform/v3/champion-rotations");
            freeChampions = new Gson().fromJson(freeChampionsFromApi, FreeChampionsModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return freeChampions;
    }
}
