package com.example.componentdemo.player.viewmodel.factory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

/**
 * @Author winiymissl
 * @Date 2024-03-22 14:01
 * @Version 1.0
 */
public class PlayActivityViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {
    public PlayActivityViewModelFactory(@NonNull Application application) {
        super(application);
    }
}