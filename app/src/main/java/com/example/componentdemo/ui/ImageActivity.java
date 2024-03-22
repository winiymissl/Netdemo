package com.example.componentdemo.ui;

import android.os.Bundle;
import android.transition.ChangeImageTransform;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.example.componentdemo.databinding.ActivityImageBinding;

public class ImageActivity extends AppCompatActivity {
    ActivityImageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
//        getWindow().setAllowEnterTransitionOverlap(true);
//        getWindow().setSharedElementEnterTransition(new ChangeImageTransform());
//        getWindow().setSharedElementExitTransition(new ChangeImageTransform());

        binding = ActivityImageBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


    }
}