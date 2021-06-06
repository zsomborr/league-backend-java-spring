package com.codecool.league.model;

import com.google.gson.annotations.SerializedName;

public class MatchHistoryModel {

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