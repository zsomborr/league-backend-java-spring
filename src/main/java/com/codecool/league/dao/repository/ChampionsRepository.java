package com.codecool.league.dao.repository;

import com.codecool.league.model.champions.ChampionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ChampionsRepository extends JpaRepository<ChampionModel, Long> {
    List<ChampionModel> findAllByTags(String tag);

    List<ChampionModel> findAllByKeyIn(List<String> favouriteChampionIds);
}
