package com.codecool.league.model.champions;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChampionsDataModel {

	@SerializedName("type")
	public String type;

	@SerializedName("format")
	public String format;

	@SerializedName("version")
	public String version;

	@SerializedName("data")
	public Map<String, ChampionModel> data;
}