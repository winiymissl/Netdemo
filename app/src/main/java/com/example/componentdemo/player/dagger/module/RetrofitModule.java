package com.example.componentdemo.player.dagger.module;

import com.example.componentdemo.player.network.VideoAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author winiymissl
 * @Date 2024-03-22 10:50
 * @Version 1.0
 */
@Module
public class RetrofitModule {
    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://fc-mp-8d5a67cf-f10b-4b55-809f-114b87614c96.next.bspapp.com/video/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public VideoAPI provideVideoAPI(Retrofit retrofit) {
        return retrofit.create(VideoAPI.class);
    }

//    @Provides
//    public VideoAPI provideRetrofit() {
//        return new Retrofit.Builder()
//                .baseUrl("https://fc-mp-8d5a67cf-f10b-4b55-809f-114b87614c96.next.bspapp.com/video/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
//                .build().create(VideoAPI.class));
//    }
}
