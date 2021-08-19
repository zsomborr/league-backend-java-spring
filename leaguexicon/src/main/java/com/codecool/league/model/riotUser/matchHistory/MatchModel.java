package com.codecool.league.model.riotUser.matchHistory;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchModel {

	@SerializedName("gameId")
	private long gameId;

	@SerializedName("champion")
	private int champion;
}