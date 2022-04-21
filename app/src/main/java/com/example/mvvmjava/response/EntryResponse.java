package com.example.mvvmjava.response;

import java.util.List;

import com.example.mvvmjava.models.EntriesItem;
import com.google.gson.annotations.SerializedName;

public class EntryResponse{

	@SerializedName("entries")
	private List<EntriesItem> entries;

	@SerializedName("count")
	private int count;

	public void setEntries(List<EntriesItem> entries){
		this.entries = entries;
	}

	public List<EntriesItem> getEntries(){
		return entries;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}
}