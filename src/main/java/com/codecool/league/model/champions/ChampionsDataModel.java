package com.codecool.league.model.champions;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ChampionsDataModel {

	@SerializedName("type")
	public String type;

	@SerializedName("format")
	public String format;

	@SerializedName("varsion")
	public String version;

	@SerializedName("data")
	public Map<String, ChampionModel> data;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Map<String, ChampionModel> getData() {
		return data;
	}

	public void setData(Map<String, ChampionModel> data) {
		this.data = data;
	}

}