package com.example.componentdemo.model.network;

import com.example.componentdemo.model.network.entities.InfoResult;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @Author winiymissl
 * @Date 2024-03-14 12:02
 * @Version 1.0
 */
public interface HistoryTodayAPI {
    //github只展示一次
    String token = "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";
    String BAI_DU = "https://aip.baidubce.com/";
    String GITHUB_API = "https://uapis.cn/api/";


    @GET("hotlist")
    Observable<InfoResult> getHistoryToday(@Query("type") String type);
}
