package com.example.mvvmjava.network;

import com.example.mvvmjava.models.EntryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("entries")
    Call<List<EntryModel>> getEntry();
}
