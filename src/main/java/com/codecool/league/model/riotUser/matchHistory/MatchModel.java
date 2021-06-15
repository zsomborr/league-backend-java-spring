package com.codecool.league.model.riotUser.matchHistory;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchModel {

	@GeneratedValue
	@Id
	private Long id;

	@SerializedName("gameId")
	private long gameId;

	@SerializedName("champion")
	private int champion;
}