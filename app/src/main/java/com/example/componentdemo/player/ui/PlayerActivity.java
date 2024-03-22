package com.example.componentdemo.player.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.componentdemo.R;
import com.example.componentdemo.player.MyApplication;
import com.example.componentdemo.player.viewmodel.PlayerActivityViewModel;
import com.example.componentdemo.player.viewmodel.factory.PlayActivityViewModelFactory;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        PlayerActivityViewModel playerActivityViewModel = new ViewModelProvider(this, new PlayActivityViewModelFactory((MyApplication) getApplication())).get(PlayerActivityViewModel.class);
        playerActivityViewModel.getVideoResultLiveData().observe(this, videoResult -> {
            // do something
        });

    }
}