package com.example.mvvmjava.response;

import java.util.List;

import com.example.mvvmjava.models.EntriesItem;
import com.google.gson.annotations.SerializedName;

public class EntryResponse {

	@SerializedName("entries")
	private List<EntriesItem> entries;

	@SerializedName("count")
	private Integer count;

	public void setEntries(List<EntriesItem> entries){
		this.entries = entries;
	}

	public List<EntriesItem> getEntries(){
		return entries;
	}

	public void setCount(Integer count){
		this.count = count;
	}

	public Integer getCount(){
		return count;
	}
}