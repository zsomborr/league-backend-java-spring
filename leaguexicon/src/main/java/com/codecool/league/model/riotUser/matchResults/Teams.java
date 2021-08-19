package com.codecool.league.model.riotUser.matchResults;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teams {

	@SerializedName("teamId")
	private int teamId;

	@SerializedName("win")
	private String win;
}