package com.codecool.league.dao.fetch.championsDao;

import com.codecool.league.model.champions.ChampionsDataModel;

public interface ChampionsDao {
    ChampionsDataModel getAllChampion();
    ChampionsDataModel getChampionsByTag(String tag);
}
