package com.example.componentdemo.player.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.componentdemo.R;
import com.example.componentdemo.databinding.ItemRecyclerviewVideoBinding;

import java.util.List;

/**
 * @Author winiymissl
 * @Date 2024-03-22 22:19
 * @Version 1.0
 */

public class VideoRecyclerviewAdapter extends RecyclerView.Adapter {
    List<MyItem> list;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecyclerviewVideoBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_recyclerview_video, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.bind(list.get(position));
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ItemRecyclerviewVideoBinding binding;

        public MyViewHolder(ItemRecyclerviewVideoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MyItem item) {
            binding.setItem(item);
            binding.executePendingBindings();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}