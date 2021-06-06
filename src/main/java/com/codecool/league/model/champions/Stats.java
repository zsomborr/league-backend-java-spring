package com.codecool.league.model.champions;

import com.google.gson.annotations.SerializedName;

public class Stats{

	@SerializedName("mpregen")
	private int mpregen;

	@SerializedName("attackdamageperlevel")
	private int attackdamageperlevel;

	@SerializedName("mp")
	private int mp;

	@SerializedName("attackrange")
	private int attackrange;

	@SerializedName("hpperlevel")
	private int hpperlevel;

	@SerializedName("hp")
	private int hp;

	@SerializedName("hpregen")
	private int hpregen;

	@SerializedName("mpregenperlevel")
	private int mpregenperlevel;

	@SerializedName("spellblock")
	private int spellblock;

	@SerializedName("critperlevel")
	private int critperlevel;

	@SerializedName("movespeed")
	private int movespeed;

	@SerializedName("mpperlevel")
	private int mpperlevel;

	@SerializedName("armor")
	private int armor;

	@SerializedName("armorperlevel")
	private double armorperlevel;

	@SerializedName("crit")
	private int crit;

	@SerializedName("attackdamage")
	private int attackdamage;

	@SerializedName("attackspeed")
	private double attackspeed;

	@SerializedName("spellblockperlevel")
	private double spellblockperlevel;

	@SerializedName("attackspeedperlevel")
	private double attackspeedperlevel;

	@SerializedName("hpregenperlevel")
	private int hpregenperlevel;

	public void setMpregen(int mpregen){
		this.mpregen = mpregen;
	}

	public int getMpregen(){
		return mpregen;
	}

	public void setAttackdamageperlevel(int attackdamageperlevel){
		this.attackdamageperlevel = attackdamageperlevel;
	}

	public int getAttackdamageperlevel(){
		return attackdamageperlevel;
	}

	public void setMp(int mp){
		this.mp = mp;
	}

	public int getMp(){
		return mp;
	}

	public void setAttackrange(int attackrange){
		this.attackrange = attackrange;
	}

	public int getAttackrange(){
		return attackrange;
	}

	public void setHpperlevel(int hpperlevel){
		this.hpperlevel = hpperlevel;
	}

	public int getHpperlevel(){
		return hpperlevel;
	}

	public void setHp(int hp){
		this.hp = hp;
	}

	public int getHp(){
		return hp;
	}

	public void setHpregen(int hpregen){
		this.hpregen = hpregen;
	}

	public int getHpregen(){
		return hpregen;
	}

	public void setMpregenperlevel(int mpregenperlevel){
		this.mpregenperlevel = mpregenperlevel;
	}

	public int getMpregenperlevel(){
		return mpregenperlevel;
	}

	public void setSpellblock(int spellblock){
		this.spellblock = spellblock;
	}

	public int getSpellblock(){
		return spellblock;
	}

	public void setCritperlevel(int critperlevel){
		this.critperlevel = critperlevel;
	}

	public int getCritperlevel(){
		return critperlevel;
	}

	public void setMovespeed(int movespeed){
		this.movespeed = movespeed;
	}

	public int getMovespeed(){
		return movespeed;
	}

	public void setMpperlevel(int mpperlevel){
		this.mpperlevel = mpperlevel;
	}

	public int getMpperlevel(){
		return mpperlevel;
	}

	public void setArmor(int armor){
		this.armor = armor;
	}

	public int getArmor(){
		return armor;
	}

	public void setArmorperlevel(double armorperlevel){
		this.armorperlevel = armorperlevel;
	}

	public double getArmorperlevel(){
		return armorperlevel;
	}

	public void setCrit(int crit){
		this.crit = crit;
	}

	public int getCrit(){
		return crit;
	}

	public void setAttackdamage(int attackdamage){
		this.attackdamage = attackdamage;
	}

	public int getAttackdamage(){
		return attackdamage;
	}

	public void setAttackspeed(double attackspeed){
		this.attackspeed = attackspeed;
	}

	public double getAttackspeed(){
		return attackspeed;
	}

	public void setSpellblockperlevel(double spellblockperlevel){
		this.spellblockperlevel = spellblockperlevel;
	}

	public double getSpellblockperlevel(){
		return spellblockperlevel;
	}

	public void setAttackspeedperlevel(double attackspeedperlevel){
		this.attackspeedperlevel = attackspeedperlevel;
	}

	public double getAttackspeedperlevel(){
		return attackspeedperlevel;
	}

	public void setHpregenperlevel(int hpregenperlevel){
		this.hpregenperlevel = hpregenperlevel;
	}

	public int getHpregenperlevel(){
		return hpregenperlevel;
	}
}