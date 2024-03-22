package com.example.componentdemo.dagger;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.componentdemo.R;

/*
* 本activity实现dagger注入
* */

public class DaggerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
    }
}