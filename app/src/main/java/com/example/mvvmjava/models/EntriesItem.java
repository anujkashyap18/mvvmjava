package com.example.mvvmjava.models;

import com.google.gson.annotations.SerializedName;

public class EntriesItem{

	@SerializedName("Description")
	private String description;

	@SerializedName("Category")
	private String category;

	@SerializedName("HTTPS")
	private Boolean hTTPS;

	@SerializedName("Auth")
	private String auth;

	@SerializedName("API")
	private String aPI;

	@SerializedName("Cors")
	private String cors;

	@SerializedName("Link")
	private String link;

	public String getDescription(){
		return description;
	}

	public String getCategory(){
		return category;
	}

	public Boolean isHTTPS(){
		return hTTPS;
	}

	public String getAuth(){
		return auth;
	}

	public String getAPI(){
		return aPI;
	}

	public String getCors(){
		return cors;
	}

	public String getLink(){
		return link;
	}
}