package com.codecool.league.model.riotUser.matchHistory;

import com.google.gson.annotations.SerializedName;

public class MatchModel {

	@SerializedName("gameId")
	private long gameId;

	@SerializedName("champion")
	private int champion;

	public void setGameId(long gameId){
		this.gameId = gameId;
	}

	public long getGameId(){
		return gameId;
	}

	public void setChampion(int champion){
		this.champion = champion;
	}

	public int getChampion(){
		return champion;
	}
}