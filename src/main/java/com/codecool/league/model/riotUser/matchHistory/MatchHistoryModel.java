package com.codecool.league.model.riotUser.matchHistory;

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
public class MatchHistoryModel {

	@SerializedName("startIndex")
	private int startIndex;

	@SerializedName("totalGames")
	private int totalGames;

	@SerializedName("endIndex")
	private int endIndex;

	@SerializedName("matches")
	private List<MatchModel> matches;
}