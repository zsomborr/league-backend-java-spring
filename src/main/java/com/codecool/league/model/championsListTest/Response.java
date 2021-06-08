package com.codecool.league.model.championsListTest;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("data")
	private Data data;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	@Override
	public String toString() {
		return "MatchHistoryModel{" +
				"data=" + data +
				'}';
	}
}