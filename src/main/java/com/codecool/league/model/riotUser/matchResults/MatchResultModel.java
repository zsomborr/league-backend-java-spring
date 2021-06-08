package com.codecool.league.model.riotUser.matchResults;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class MatchResultModel{

	@SerializedName("gameId")
	private long gameId;

	@SerializedName("gameDuration")
	private int gameDuration;

	@SerializedName("teams")
	private List<Teams> teams;

	@SerializedName("gameMode")
	private String gameMode;

	public void setGameId(long gameId){
		this.gameId = gameId;
	}

	public long getGameId(){
		return gameId;
	}

	public void setGameDuration(int gameDuration){
		this.gameDuration = gameDuration;
	}

	public int getGameDuration(){
		return gameDuration;
	}

	public void setTeams(List<Teams> teams){
		this.teams = teams;
	}

	public List<Teams> getTeams(){
		return teams;
	}

	public void setGameMode(String gameMode){
		this.gameMode = gameMode;
	}

	public String getGameMode(){
		return gameMode;
	}
}