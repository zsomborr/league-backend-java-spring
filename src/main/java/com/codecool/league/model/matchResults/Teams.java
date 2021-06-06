package com.codecool.league.model.matchResults;

import com.google.gson.annotations.SerializedName;

public class Teams {

	@SerializedName("teamId")
	private int teamId;

	@SerializedName("win")
	private String win;

	public void setTeamId(int teamId){
		this.teamId = teamId;
	}

	public int getTeamId(){
		return teamId;
	}

	public void setWin(String win){
		this.win = win;
	}

	public String getWin(){
		return win;
	}
}