package com.example.mvvmjava.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmjava.network.ApiService;
import com.example.mvvmjava.network.RetrofitInstance;
import com.example.mvvmjava.response.EntryResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntryRepository {
    private static final String TAG = EntryRepository.class.getSimpleName();
    private ApiService apiService;

    public EntryRepository() {
        apiService = RetrofitInstance.getRetrofit().create(ApiService.class);
    }

    public LiveData<EntryResponse> getEntryData() {
        final MutableLiveData<EntryResponse> data = new MutableLiveData<>();
        apiService.entryData().enqueue(new Callback<EntryResponse>() {
            @Override
            public void onResponse(Call<EntryResponse> call, Response<EntryResponse> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                    Log.d(TAG, "SUCCESS RESPONSE : " + response.body().getEntries());
                }
            }

            @Override
            public void onFailure(Call<EntryResponse> call, Throwable t) {
                data.setValue(null);
                Log.d(TAG, "ERROR RESPONSE : " + t);
            }
        });
        return data;
    }
}
