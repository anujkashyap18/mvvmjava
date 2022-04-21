package com.example.mvvmjava.network;

import com.example.mvvmjava.response.EntryResponse;
import com.example.mvvmjava.models.RecyclerData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("63OH")
    Call<RecyclerData> getEntry();

    @GET("entries")
    Call<List<EntryResponse>> getEntryData();

    @GET("entries")
    Call<EntryResponse> entryData();
}
