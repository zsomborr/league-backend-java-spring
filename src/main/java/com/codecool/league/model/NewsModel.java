package com.codecool.league.model;

import com.google.gson.annotations.SerializedName;

public class NewsModel{

	@SerializedName("time_ago")
	private String timeAgo;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("user")
	private String user;

	@SerializedName("url")
	private String url;

	public void setTimeAgo(String timeAgo){
		this.timeAgo = timeAgo;
	}

	public String getTimeAgo(){
		return timeAgo;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUser(String user){
		this.user = user;
	}

	public String getUser(){
		return user;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}