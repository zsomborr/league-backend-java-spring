package com.codecool.league.model.championsListTest;

import com.google.gson.annotations.SerializedName;

public class Info{

	@SerializedName("magic")
	private int magic;

	@SerializedName("difficulty")
	private int difficulty;

	@SerializedName("defense")
	private int defense;

	@SerializedName("attack")
	private int attack;

	public void setMagic(int magic){
		this.magic = magic;
	}

	public int getMagic(){
		return magic;
	}

	public void setDifficulty(int difficulty){
		this.difficulty = difficulty;
	}

	public int getDifficulty(){
		return difficulty;
	}

	public void setDefense(int defense){
		this.defense = defense;
	}

	public int getDefense(){
		return defense;
	}

	public void setAttack(int attack){
		this.attack = attack;
	}

	public int getAttack(){
		return attack;
	}
}