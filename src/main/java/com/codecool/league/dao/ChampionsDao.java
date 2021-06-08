package com.codecool.league.dao;

import com.codecool.league.model.champions.ChampionsModel;
import com.codecool.league.model.championsListTest.ChampionModel;

import java.util.List;

public interface ChampionsDao {
    ChampionsModel getAllChampion();
    List<ChampionModel>  getChampionsByTag(String tag);

}
