package com.example.mvvmjava.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class EntryModel{

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