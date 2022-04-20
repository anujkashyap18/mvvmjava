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

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setHTTPS(Boolean hTTPS){
		this.hTTPS = hTTPS;
	}

	public Boolean isHTTPS(){
		return hTTPS;
	}

	public void setAuth(String auth){
		this.auth = auth;
	}

	public String getAuth(){
		return auth;
	}

	public void setAPI(String aPI){
		this.aPI = aPI;
	}

	public String getAPI(){
		return aPI;
	}

	public void setCors(String cors){
		this.cors = cors;
	}

	public String getCors(){
		return cors;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}
}