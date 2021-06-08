package com.codecool.league.model.champions;

import com.google.gson.annotations.SerializedName;

public class ChampionsModel{

	@SerializedName("data")
	private Data data;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}
}