package com.example.componentdemo.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.componentdemo.model.network.MyRetrofit;
import com.example.componentdemo.model.network.entities.InfoResult;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @Author winiymissl
 * @Date 2024-03-14 11:56
 * @Version 1.0
 */
public class DemoActivityViewModel extends ViewModel {

    private MutableLiveData<InfoResult> data = new MutableLiveData<>();
    private boolean mIsDataLoaded = false;

    public MutableLiveData<InfoResult> getData() {
        return data;
    }

    public void fetchData() {
        //进行rxjava的逻辑
        //rxjava申请数据
        /*
         * 通过调试发现livedata会自动恢复数据，所以网络调用最好只执行一次
         *
         * */
        if (!mIsDataLoaded) {
            MyRetrofit.githubAPI.getHistoryToday("history")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())  // 再切换到主线程
                    .subscribe((ob) -> {
                        data.setValue(ob);
                        mIsDataLoaded = true;
                    });
        }

        Log.d("数据发生变化", "数据发生变化");
    }
}
