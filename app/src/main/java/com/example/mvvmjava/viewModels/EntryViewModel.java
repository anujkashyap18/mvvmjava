package com.example.mvvmjava.viewModels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmjava.network.ApiService;
import com.example.mvvmjava.network.RetrofitInstance;
import com.example.mvvmjava.response.EntryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntryViewModel extends ViewModel {

//    private final MutableLiveData<List<RecyclerData>> entryList;
    private  MutableLiveData<List<EntryResponse>> entryListTwo;

    public EntryViewModel() {
//        entryList = new MutableLiveData<>();
        entryListTwo = new MutableLiveData<>();
    }

//    public MutableLiveData<List<RecyclerData>> getEntryObserver() {
//        return entryList;
//    }

    public MutableLiveData<List<EntryResponse>> getEntryObserverTwo() {
        return entryListTwo;
    }


    public void entryApiCall(){
        ApiService apiService = RetrofitInstance.getRetrofit().create(ApiService.class);
        Call<List<EntryResponse>> call = apiService.getEntryData();
        call.enqueue(new Callback<List<EntryResponse>>() {
            @Override
            public void onResponse(Call<List<EntryResponse>> call, Response<List<EntryResponse>> response) {
                Log.d("SDSDZ","SUCCESS RESPONSE :"+response);
                entryListTwo.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<EntryResponse>> call, Throwable t) {
                Log.d("AAS","ERROR RESPONSE : "+t);
                entryListTwo.postValue(null);
            }
        });
    }

//    public void entryApiCallTwo(){
//        ApiService apiService = RetrofitInstance.getRetrofit().create(ApiService.class);
//        Call<EntryModel> call = apiService.getEntryData();
//        call.enqueue(new Callback<EntryModel>() {
//            @Override
//            public void onResponse(Call<EntryModel> call, Response<EntryModel> response) {
//                entryListTwo.postValue(Collections.singletonList(response.body()));
//            }
//
//            @Override
//            public void onFailure(Call<EntryModel> call, Throwable t) {
//                entryListTwo.postValue(null);
//            }
//        });
//    }
}
