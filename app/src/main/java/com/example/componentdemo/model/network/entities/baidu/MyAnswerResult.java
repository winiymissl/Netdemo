package com.example.componentdemo.model.network.entities.baidu;

/**
 * @Author winiymissl
 * @Date 2024-03-18 14:50
 * @Version 1.0
 */
public class MyAnswerResult {
    public String result;

    public String getResult() {
        return result;
    }

    String error_code;
    String error_msg;

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
