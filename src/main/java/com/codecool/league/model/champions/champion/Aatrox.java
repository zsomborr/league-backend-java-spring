package com.codecool.league.model.champions.champion;

import java.util.List;

import com.codecool.league.model.champions.Image;
import com.codecool.league.model.champions.Info;
import com.codecool.league.model.champions.Stats;
import com.google.gson.annotations.SerializedName;

public class Aatrox{

	@SerializedName("image")
	private Image image;

	@SerializedName("stats")
	private Stats stats;

	@SerializedName("partype")
	private String partype;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("title")
	private String title;

	@SerializedName("blurb")
	private String blurb;

	@SerializedName("version")
	private String version;

	@SerializedName("key")
	private String key;

	@SerializedName("info")
	private Info info;

	@SerializedName("tags")
	private List<String> tags;

	public void setImage(Image image){
		this.image = image;
	}

	public Image getImage(){
		return image;
	}

	public void setStats(Stats stats){
		this.stats = stats;
	}

	public Stats getStats(){
		return stats;
	}

	public void setPartype(String partype){
		this.partype = partype;
	}

	public String getPartype(){
		return partype;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setBlurb(String blurb){
		this.blurb = blurb;
	}

	public String getBlurb(){
		return blurb;
	}

	public void setVersion(String version){
		this.version = version;
	}

	public String getVersion(){
		return version;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	public void setInfo(Info info){
		this.info = info;
	}

	public Info getInfo(){
		return info;
	}

	public void setTags(List<String> tags){
		this.tags = tags;
	}

	public List<String> getTags(){
		return tags;
	}
}