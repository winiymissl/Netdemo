package com.example.componentdemo.player.network;

import com.example.componentdemo.player.network.entity.VideoRequest;
import com.example.componentdemo.player.network.entity.VideoResult;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * @Author winiymissl
 * @Date 2024-03-22 10:42
 * @Version 1.0
 */
public interface VideoAPI {
    @Headers("Content-Type: application/json")
    @POST("getVideoType")
    Observable<VideoResult> getVideoResult(@Body VideoRequest videoRequest);
}
