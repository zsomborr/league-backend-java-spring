package com.codecool.league.dao;

import com.codecool.league.model.champions.ChampionModel;

import java.util.List;

public interface ChampionsDao {
    List<ChampionModel> getAllChampion();
    List<ChampionModel>  getChampionByTag(String tag);

}
