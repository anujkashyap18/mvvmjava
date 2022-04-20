package com.example.mvvmjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvmjava.models.EntryModel;
import com.example.mvvmjava.models.RecyclerData;
import com.example.mvvmjava.network.ApiService;
import com.example.mvvmjava.network.RetrofitInstance;
import com.example.mvvmjava.viewModels.EntryViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<RecyclerData> list = new ArrayList<>();
    private EntryViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(EntryViewModel.class);

        viewModel.getEntryObserverTwo().observe(this, new Observer<List<EntryModel>>() {
            @Override
            public void onChanged(List<EntryModel> entryModels) {
                if (entryModels != null){
                    Toast.makeText(MainActivity.this, "Success : "+entryModels.get(0).getEntries().get(0).getAPI(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewModel.entryApiCallTwo();

//        ApiService apiService = RetrofitInstance.getRetrofit().create(ApiService.class);
//        Call<RecyclerData> call = apiService.getEntry();
//        call.enqueue(new Callback<RecyclerData>() {
//            @Override
//            public void onResponse(Call<RecyclerData> call, Response<RecyclerData> response) {
//                Toast.makeText(MainActivity.this, "success"+response, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<RecyclerData> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "error"+t, Toast.LENGTH_SHORT).show();
//            }
//        });


    }
}