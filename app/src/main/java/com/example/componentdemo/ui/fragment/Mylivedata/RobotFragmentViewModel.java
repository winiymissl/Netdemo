package com.example.componentdemo.ui.fragment.Mylivedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.componentdemo.model.network.entities.baidu.request.MyMessage;

import java.util.List;

/**
 * @Author winiymissl
 * @Date 2024-03-18 14:35
 * @Version 1.0
 */
public class RobotFragmentViewModel extends ViewModel {
    private MutableLiveData<List<MyMessage>> messageData = new MutableLiveData<>();

    public void setMessageData(MutableLiveData<List<MyMessage>> messageData) {
        this.messageData = messageData;
    }

    public MutableLiveData<List<MyMessage>> getMessageData() {
        return messageData;
    }
}
