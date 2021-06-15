package com.codecool.league.model.news;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}