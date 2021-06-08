package com.codecool.league.model.champions;

import com.google.gson.annotations.SerializedName;

public class Image{

	@SerializedName("w")
	private int W;

	@SerializedName("sprite")
	private String sprite;

	@SerializedName("x")
	private int X;

	@SerializedName("h")
	private int H;

	@SerializedName("y")
	private int Y;

	@SerializedName("full")
	private String full;

	@SerializedName("group")
	private String group;

	public void setW(int W){
		this.W = W;
	}

	public int getW(){
		return W;
	}

	public void setSprite(String sprite){
		this.sprite = sprite;
	}

	public String getSprite(){
		return sprite;
	}

	public void setX(int X){
		this.X = X;
	}

	public int getX(){
		return X;
	}

	public void setH(int H){
		this.H = H;
	}

	public int getH(){
		return H;
	}

	public void setY(int Y){
		this.Y = Y;
	}

	public int getY(){
		return Y;
	}

	public void setFull(String full){
		this.full = full;
	}

	public String getFull(){
		return full;
	}

	public void setGroup(String group){
		this.group = group;
	}

	public String getGroup(){
		return group;
	}
}