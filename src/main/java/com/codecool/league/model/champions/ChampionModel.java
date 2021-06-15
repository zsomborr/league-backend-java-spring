package com.codecool.league.model.champions;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChampionModel {

	@SerializedName("stats")
	private Stats stats;

	@SerializedName("partype")
	private String partype;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("title")
	private String title;

	@SerializedName("blurb")
	private String blurb;

	@SerializedName("version")
	private String version;

	@SerializedName("key")
	private String key;

	@SerializedName("info")
	private Info info;

	@SerializedName("tags")
	private List<String> tags;

	private Boolean free = false;
}