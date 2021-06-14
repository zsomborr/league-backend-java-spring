package com.codecool.league.model.champions;

import java.util.LinkedHashSet;
import java.util.Set;

public class ChampionsDataModel {

	private Set<ChampionModel> championModels = new LinkedHashSet<>();

	public void putInSet(ChampionModel championModel) {
		championModels.add(championModel);
	}

	public Set<ChampionModel> getChampionModels() {
		return championModels;
	}

	public void setChampionModels(Set<ChampionModel> championModels) {
		this.championModels = championModels;
	}
}