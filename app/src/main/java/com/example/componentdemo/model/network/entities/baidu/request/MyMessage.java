package com.example.componentdemo.model.network.entities.baidu.request;

/**
 * @Author winiymissl
 * @Date 2024-03-18 15:16
 * @Version 1.0
 */

public class MyMessage {
    private String role;
    private String content;


    public void setRole(String role) {
        this.role = role;
    }

    public MyMessage(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
