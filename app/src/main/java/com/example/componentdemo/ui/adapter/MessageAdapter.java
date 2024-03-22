package com.example.componentdemo.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.componentdemo.model.network.entities.baidu.request.MyMessage;

import java.util.List;

/**
 * @Author winiymissl
 * @Date 2024-03-18 15:19
 * @Version 1.0
 */
public class MessageAdapter extends RecyclerView.Adapter {
    List<MyMessage> list;

    public MessageAdapter(List<MyMessage> list) {
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
        MyMessage myMessage = list.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.textView.setText(myMessage.getContent());
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

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
