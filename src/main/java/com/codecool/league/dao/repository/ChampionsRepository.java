package com.codecool.league.dao.repository;

import com.codecool.league.model.champions.ChampionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ChampionsRepository extends JpaRepository<ChampionModel, Long> {
    List<ChampionModel> findAllByTags(String tag);

    List<ChampionModel> findAllByKeyIn(List<String> favouriteChampionIds);
}
