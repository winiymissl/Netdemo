package com.example.componentdemo.ui.fragment.Mylivedata;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.componentdemo.model.network.MyRetrofit;
import com.example.componentdemo.model.network.entities.InfoResult;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @Author winiymissl
 * @Date 2024-03-17 12:22
 * @Version 1.0
 */

public class TestFragmentLiveData {
    private MutableLiveData<List<InfoResult.InfoResultData>> listMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<InfoResult.InfoResultData>> getData() {
        return listMutableLiveData;
    }

    public void fetchData() {
        MyRetrofit.githubAPI.getHistoryToday("weibo")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(data -> {
                    listMutableLiveData.setValue(data.getData());
                }, throwable -> {
                    Log.d("问题", throwable.toString());
                });
    }
}
