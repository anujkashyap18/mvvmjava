package com.example.mvvmjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvmjava.models.EntryModel;
import com.example.mvvmjava.viewModels.EntryViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<EntryModel> list = new ArrayList<>();
    private EntryViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(EntryViewModel.class);
        viewModel.getEntryObserver().observe(this, new Observer<List<EntryModel>>() {
            @Override
            public void onChanged(List<EntryModel> entriesResponses) {
                if (entriesResponses != null) {
                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
//                for (int i =0;i<entriesResponses.size();i++){
//                    list.add((EntriesItem) entriesResponses.get(i).getEntries());
//                }
                } else {
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });
        viewModel.entryApiCall();
    }
}