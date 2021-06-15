package com.codecool.league.model.champions;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ChampionModel {

	@SerializedName("stats")
	@Embedded
	private Stats stats;

	@SerializedName("partype")
	private String partype;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	@Id
	private String id;

	@SerializedName("title")
	private String title;

	@Lob
	@Column
	@SerializedName("blurb")
	private String blurb;

	@SerializedName("version")
	private String version;

	@SerializedName("key")
	private String key;

	@Embedded
	@SerializedName("info")
	private Info info;

	@SerializedName("tags")
	@ElementCollection
	private List<String> tags;

	private Boolean free = false;
}