package com.example.componentdemo.player.network.entity;

/**
 * @Author winiymissl
 * @Date 2024-03-22 21:32
 * @Version 1.0
 */
public class VideoRequest {
    int page;
    int type;

    public VideoRequest(int page, int type) {
        this.page = page;
        this.type = type;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
