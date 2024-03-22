package com.example.componentdemo.player.ui.adapter.customattr;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

/**
 * @Author winiymissl
 * @Date 2024-03-22 22:50
 * @Version 1.0
 */
public class CustomBindingAdapter {
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }
}
