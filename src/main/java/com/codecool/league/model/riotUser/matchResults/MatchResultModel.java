package com.codecool.league.model.riotUser.matchResults;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchResultModel{

	@SerializedName("gameId")
	private long gameId;

	@SerializedName("gameDuration")
	private int gameDuration;

	@SerializedName("teams")
	private List<Teams> teams;

	@SerializedName("gameMode")
	private String gameMode;
}