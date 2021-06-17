package com.codecool.league.model.riotUser.matchResults;

import com.google.gson.annotations.SerializedName;
import lombok.*;

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

	@Singular
	@SerializedName("teams")
	private List<Teams> teams;

	@SerializedName("gameMode")
	private String gameMode;
}