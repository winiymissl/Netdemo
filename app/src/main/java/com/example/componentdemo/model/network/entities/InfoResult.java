package com.example.componentdemo.model.network.entities;

import java.util.List;

/**
 * @Author winiymissl
 * @Date 2024-03-14 19:05
 * @Version 1.0
 */
public class InfoResult {
    String title;
    List<InfoResultData> data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<InfoResultData> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "InfoResult{" +
                "title='" + title + '\'' +
                ", data=" + data +
                '}';
    }

    public void setData(List<InfoResultData> data) {
        this.data = data;
    }

    public static class InfoResultData {
        String title;

        @Override
        public String toString() {
            return "InfoResultData{" +
                    "title='" + title + '\'' +
                    '}';
        }

        public InfoResultData(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
