package com.example.mvvmjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmjava.R;
import com.example.mvvmjava.models.EntriesItem;

import java.util.ArrayList;

public class EntryAdapter extends RecyclerView.Adapter<EntryAdapter.EntryHolder>{

    Context context;
    ArrayList<EntriesItem> list;

    public EntryAdapter(Context context, ArrayList<EntriesItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EntryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EntryHolder(LayoutInflater.from(context).inflate(R.layout.custom_entry_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull EntryHolder holder, int position) {
        Toast.makeText(context, ""+list.get(position).getAPI(), Toast.LENGTH_SHORT).show();
        holder.apiName.setText(list.get(position).getAPI());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class EntryHolder extends RecyclerView.ViewHolder {
        TextView apiName;
        public EntryHolder(@NonNull View itemView) {
            super(itemView);
            apiName = itemView.findViewById(R.id.apiName);
        }
    }
}
