package com.codecool.league.model.champions;

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
@Embeddable
public class Info {

	@SerializedName("magic")
	private int magic;

	@SerializedName("difficulty")
	private int difficulty;

	@SerializedName("defense")
	private int defense;

	@SerializedName("attack")
	private int attack;
}