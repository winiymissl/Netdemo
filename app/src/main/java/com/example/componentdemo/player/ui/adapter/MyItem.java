package com.example.componentdemo.player.ui.adapter;

/**
 * @Author winiymissl
 * @Date 2024-03-22 22:21
 * @Version 1.0
 */
public class MyItem {
    String name;
    String image_url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String remarks;

    public MyItem(String name, String image_url, String remarks) {
        this.name = name;
        this.image_url = image_url;
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
