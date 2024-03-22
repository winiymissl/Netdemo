package com.example.componentdemo.dagger;

/**
 * @Author winiymissl
 * @Date 2024-03-19 22:12
 * @Version 1.0
 */
//@dagger.Component(modules = {StudentModule.class})
public interface Component {
    void inject(Student student);
}
