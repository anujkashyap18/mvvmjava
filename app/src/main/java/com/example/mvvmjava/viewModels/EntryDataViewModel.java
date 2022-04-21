package com.example.mvvmjava.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvmjava.repository.EntryRepository;
import com.example.mvvmjava.response.EntryResponse;

public class EntryDataViewModel extends AndroidViewModel {

    private EntryRepository repository;
    private LiveData<EntryResponse> entryResponseLiveData;

    public EntryDataViewModel(@NonNull Application application) {
        super(application);
        repository = new EntryRepository();
        this.entryResponseLiveData = repository.getEntryData();
    }

    public LiveData<EntryResponse> getEntryResponseLiveData(){
        return entryResponseLiveData;
    }
}
