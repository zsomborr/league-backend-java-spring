package com.codecool.league.model.champions;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

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