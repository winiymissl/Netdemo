package com.example.componentdemo.model.network.entities.baidu.request;

import java.util.List;

/**
 * @Author winiymissl
 * @Date 2024-03-18 20:18
 * @Version 1.0
 */
public class MessageRequest {

    List<MyMessage> messages;


    public void setMessages(List<MyMessage> messages) {
        this.messages = messages;
    }

    public MessageRequest(List<MyMessage> messages) {
        this.messages = messages;
    }

}
