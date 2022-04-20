package com.example.mvvmjava.viewModels;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmjava.MainActivity;
import com.example.mvvmjava.models.EntryModel;
import com.example.mvvmjava.models.RecyclerData;
import com.example.mvvmjava.network.ApiService;
import com.example.mvvmjava.network.RetrofitInstance;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntryViewModel extends ViewModel {

//    private final MutableLiveData<List<RecyclerData>> entryList;
    private final MutableLiveData<List<EntryModel>> entryListTwo;

    public EntryViewModel() {
//        entryList = new MutableLiveData<>();
        entryListTwo = new MutableLiveData<>();
    }

//    public MutableLiveData<List<RecyclerData>> getEntryObserver() {
//        return entryList;
//    }

    public MutableLiveData<List<EntryModel>> getEntryObserverTwo() {
        return entryListTwo;
    }


//    public void entryApiCall(){
//        ApiService apiService = RetrofitInstance.getRetrofit().create(ApiService.class);
//        Call<RecyclerData> call = apiService.getEntry();
//        call.enqueue(new Callback<RecyclerData>() {
//            @Override
//            public void onResponse(Call<RecyclerData> call, Response<RecyclerData> response) {
//                entryList.postValue(Collections.singletonList(response.body()));
//            }
//
//            @Override
//            public void onFailure(Call<RecyclerData> call, Throwable t) {
//                entryList.postValue(null);
//            }
//        });
//    }

    public void entryApiCallTwo(){
        ApiService apiService = RetrofitInstance.getRetrofit().create(ApiService.class);
        Call<EntryModel> call = apiService.getEntryData();
        call.enqueue(new Callback<EntryModel>() {
            @Override
            public void onResponse(Call<EntryModel> call, Response<EntryModel> response) {
                entryListTwo.postValue(Collections.singletonList(response.body()));
            }

            @Override
            public void onFailure(Call<EntryModel> call, Throwable t) {
                entryListTwo.postValue(null);
            }
        });
    }
}
