package com.codecool.league.service.fetch.freeChampionsFetch;

import com.codecool.league.model.freeChampions.FreeChampionsModel;
import com.codecool.league.util.ApiResponseUtil;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class FreeChampionsFetchService implements FreeChampionsFetch {

    private final String FREE_CHAMPIONS_ENDPOINT = "https://eun1.api.riotgames.com/lol/platform/v3/champion-rotations";

    @Override
    public FreeChampionsModel getFreeChampions() {
        FreeChampionsModel freeChampions = null;
        try {
            String freeChampionsFromApi = ApiResponseUtil.getRiotApiJsonResponse(FREE_CHAMPIONS_ENDPOINT);
            freeChampions = new Gson().fromJson(freeChampionsFromApi, FreeChampionsModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return freeChampions;
    }
}
