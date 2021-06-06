package com.codecool.league.model;

import com.google.gson.annotations.SerializedName;

public class RiotUserDetailModel{

	@SerializedName("accountId")
	private String accountId;

	@SerializedName("profileIconId")
	private int profileIconId;

	@SerializedName("name")
	private String name;

	@SerializedName("puuid")
	private String puuid;

	@SerializedName("summonerLevel")
	private int summonerLevel;

	public void setAccountId(String accountId){
		this.accountId = accountId;
	}

	public String getAccountId(){
		return accountId;
	}

	public void setProfileIconId(int profileIconId){
		this.profileIconId = profileIconId;
	}

	public int getProfileIconId(){
		return profileIconId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPuuid(String puuid){
		this.puuid = puuid;
	}

	public String getPuuid(){
		return puuid;
	}

	public void setSummonerLevel(int summonerLevel){
		this.summonerLevel = summonerLevel;
	}

	public int getSummonerLevel(){
		return summonerLevel;
	}
}