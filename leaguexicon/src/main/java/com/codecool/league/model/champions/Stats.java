package com.codecool.league.model.champions;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Stats {

	@SerializedName("mpregen")
	private double mpregen;

	@SerializedName("attackdamageperlevel")
	private double attackdamageperlevel;

	@SerializedName("mp")
	private double mp;

	@SerializedName("attackrange")
	private double attackrange;

	@SerializedName("hpperlevel")
	private double hpperlevel;

	@SerializedName("hp")
	private double hp;

	@SerializedName("hpregen")
	private double hpregen;

	@SerializedName("mpregenperlevel")
	private double mpregenperlevel;

	@SerializedName("spellblock")
	private double spellblock;

	@SerializedName("critperlevel")
	private double critperlevel;

	@SerializedName("movespeed")
	private double movespeed;

	@SerializedName("mpperlevel")
	private double mpperlevel;

	@SerializedName("armor")
	private double armor;

	@SerializedName("armorperlevel")
	private double armorperlevel;

	@SerializedName("crit")
	private double crit;

	@SerializedName("attackdamage")
	private double attackdamage;

	@SerializedName("attackspeed")
	private double attackspeed;

	@SerializedName("spellblockperlevel")
	private double spellblockperlevel;

	@SerializedName("attackspeedperlevel")
	private double attackspeedperlevel;

	@SerializedName("hpregenperlevel")
	private double hpregenperlevel;
}