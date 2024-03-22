package com.example.componentdemo.model.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author winiymissl
 * @Date 2024-03-14 19:08
 * @Version 1.0
 */
public class MyRetrofit {
    private static final Retrofit MY_RETROFIT_API = new Retrofit.Builder().baseUrl(HistoryTodayAPI.GITHUB_API).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build();

    public static final HistoryTodayAPI githubAPI = MY_RETROFIT_API.create(HistoryTodayAPI.class);

    private static final Retrofit BAI_DU_API = new Retrofit.Builder().baseUrl(BaiDuAPI.BAI_DU).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build();
    public static final BaiDuAPI baiDuAPI = BAI_DU_API.create(BaiDuAPI.class);
}
