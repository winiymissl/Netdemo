package com.example.componentdemo.player.dagger;

import com.example.componentdemo.player.dagger.module.RetrofitModule;
import com.example.componentdemo.player.ui.PlayerActivity;
import com.example.componentdemo.player.viewmodel.PlayerActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @Author winiymissl
 * @Date 2024-03-22 10:58
 * @Version 1.0
 */
@Component(modules = RetrofitModule.class)
@Singleton
public interface VideoComponent {
    void injectTo(PlayerActivityViewModel playerActivityViewModel);

    void injectTo(PlayerActivity playerActivity);
}
