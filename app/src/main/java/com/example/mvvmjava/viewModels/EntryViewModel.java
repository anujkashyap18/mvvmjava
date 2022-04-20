package com.example.mvvmjava.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmjava.models.EntryModel;
import com.example.mvvmjava.network.ApiService;
import com.example.mvvmjava.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntryViewModel extends ViewModel {

    private MutableLiveData<List<EntryModel>> entryList;

    public EntryViewModel() {
        entryList = new MutableLiveData<>();
    }

    public MutableLiveData<List<EntryModel>> getEntryObserver(){
        return entryList;
    }

    public void entryApiCall(){
        ApiService apiService = RetrofitInstance.getRetrofit().create(ApiService.class);
        Call<List<EntryModel>> call = apiService.getEntry();
        call.enqueue(new Callback<List<EntryModel>>() {
            @Override
            public void onResponse(Call<List<EntryModel>> call, Response<List<EntryModel>> response) {
                entryList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<EntryModel>> call, Throwable t) {
                entryList.postValue(null);
            }

        });
    }
}
