package com.example.mvvmjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvmjava.adapter.EntryAdapter;
import com.example.mvvmjava.models.EntriesItem;
import com.example.mvvmjava.viewModels.EntryDataViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<EntriesItem> list = new ArrayList<>();
    EntryDataViewModel viewModelTwo;
    EntryAdapter entryAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
        getEntryData();
    }

    private void initialization(){

        recyclerView = findViewById(R.id.entryRecycler);
        recyclerView.setHasFixedSize(true);

        entryAdapter = new EntryAdapter(MainActivity.this,list);

        viewModelTwo = ViewModelProviders.of(this).get(EntryDataViewModel.class);
    }

    private void getEntryData(){
        viewModelTwo.getEntryResponseLiveData().observe(this, entryResponse -> {
            if (entryResponse != null){
                for (int i =0;i<entryResponse.getEntries().size();i++){
                    list.add(entryResponse.getEntries().get(i));
                }
//                List<EntriesItem> entryList = entryResponse.getEntries();
//                list.addAll(entryList);
                entryAdapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}