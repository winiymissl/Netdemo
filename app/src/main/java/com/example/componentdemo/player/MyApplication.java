package com.example.componentdemo.player;

import android.app.Application;

import com.example.componentdemo.player.dagger.DaggerVideoComponent;
import com.example.componentdemo.player.dagger.VideoComponent;

/**
 * @Author winiymissl
 * @Date 2024-03-22 10:48
 * @Version 1.0
 */
public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    VideoComponent videoComponent;

    public VideoComponent getVideoComponent() {
        if (videoComponent == null) {
            videoComponent = DaggerVideoComponent.create();
            return videoComponent;
        }
        return videoComponent;
    }
}
