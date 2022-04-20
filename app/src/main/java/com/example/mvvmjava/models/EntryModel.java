package com.example.mvvmjava.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class EntryModel{

	@SerializedName("entries")
	private List<EntriesItem> entries;

	@SerializedName("count")
	private Integer count;

	public List<EntriesItem> getEntries(){
		return entries;
	}

	public Integer getCount(){
		return count;
	}
}