package com.codecool.league.model.riotUser.matchHistory;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchHistoryModel {

	@SerializedName("startIndex")
	private int startIndex;

	@SerializedName("totalGames")
	private int totalGames;

	@SerializedName("endIndex")
	private int endIndex;

	@Singular
	@SerializedName("matches")
	private List<MatchModel> matches;
}