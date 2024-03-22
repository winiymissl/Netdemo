package com.example.componentdemo.player.network.entity;

import com.example.componentdemo.player.network.BasicResult;

import java.util.List;

/**
 * @Author winiymissl
 * @Date 2024-03-22 10:44
 * @Version 1.0
 */
public class VideoResult extends BasicResult {
    VideoResultData data;

    public VideoResultData getData() {
        return data;
    }

    public void setData(VideoResultData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "VideoResult{" +
                "data=" + data +
                '}';
    }

    public class VideoResultData {
        private List<VideoResultDataData> list;

        public List<VideoResultDataData> getList() {
            return list;
        }

        public void setList(List<VideoResultDataData> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            return "VideoResult{" +
                    "list=" + list +
                    '}';
        }
    }

    public class VideoResultDataData {
        @Override
        public String toString() {
            return "VideoResultData{" +
                    "name='" + name + '\'' +
                    ", pic='" + pic + '\'' +
                    ", remarks='" + remarks + '\'' +
                    '}';
        }

        private String name;
        private String pic;
        private String remarks;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }
    }
}
