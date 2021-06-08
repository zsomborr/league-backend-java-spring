package com.codecool.league.model.riotUser.matchHistory;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MatchHistoryModel {

	@SerializedName("startIndex")
	private int startIndex;

	@SerializedName("totalGames")
	private int totalGames;

	@SerializedName("endIndex")
	private int endIndex;

	@SerializedName("matches")
	private List<MatchModel> matches;

	public void setStartIndex(int startIndex){
		this.startIndex = startIndex;
	}

	public int getStartIndex(){
		return startIndex;
	}

	public void setTotalGames(int totalGames){
		this.totalGames = totalGames;
	}

	public int getTotalGames(){
		return totalGames;
	}

	public void setEndIndex(int endIndex){
		this.endIndex = endIndex;
	}

	public int getEndIndex(){
		return endIndex;
	}

	public void setMatches(List<MatchModel> matches){
		this.matches = matches;
	}

	public List<MatchModel> getMatches(){
		return matches;
	}
}