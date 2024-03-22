package com.example.componentdemo.player.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.componentdemo.player.MyApplication;
import com.example.componentdemo.player.network.VideoAPI;
import com.example.componentdemo.player.network.entity.VideoRequest;
import com.example.componentdemo.player.network.entity.VideoResult;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @Author winiymissl
 * @Date 2024-03-22 10:38
 * @Version 1.0
 */
public class PlayerActivityViewModel extends AndroidViewModel {
    @Inject
    VideoAPI videoAPI;

    MutableLiveData<VideoResult> videoResultLiveData = new MutableLiveData<>();

    public PlayerActivityViewModel(@NonNull MyApplication application) {
        super(application);
    }

    public LiveData<VideoResult> getVideoResultLiveData() {
        ((MyApplication) getApplication()).getVideoComponent().injectTo(this);
//        DaggerVideoComponent.builder().retrofitModule(new RetrofitModule()).retrofitModule(new RetrofitModule()).build();
        videoAPI.getVideoResult(new VideoRequest(1, 8)).subscribeOn(AndroidSchedulers.mainThread()).observeOn(Schedulers.io()).subscribe(result -> {
            Log.d("返回的数据", result.toString());
            videoResultLiveData.setValue(result);
        });
        return videoResultLiveData;
    }

    public void setVideoResultLiveData(MutableLiveData<VideoResult> videoResultLiveData) {
        this.videoResultLiveData = videoResultLiveData;
    }
}
