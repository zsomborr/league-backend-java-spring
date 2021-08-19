package com.codecool.league.service.fetch.championsFetch;

import com.codecool.league.model.champions.ChampionsDataModel;

public interface ChampionsFetch {
    ChampionsDataModel getAllChampion();
    ChampionsDataModel getChampionsByTag(String tag);
}
