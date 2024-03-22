package com.example.componentdemo.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.componentdemo.model.network.entities.InfoResult;

import java.util.List;

/**
 * @Author winiymissl
 * @Date 2024-03-14 18:26
 * @Version 1.0
 */
public class RecyclerviewAdapter extends RecyclerView.Adapter {
    List<InfoResult.InfoResultData> list;

    public RecyclerviewAdapter(List<InfoResult.InfoResultData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        InfoResult.InfoResultData data = list.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.textView.setText(data.getTitle());
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}