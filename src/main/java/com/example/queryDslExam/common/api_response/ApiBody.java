package com.example.queryDslExam.common.api_response;

public class ApiBody<T> {
    private T data;
    private T msg;

    public ApiBody(T data, T msg) {
        this.data = data;
        this.msg = msg;
    }
    public T getData() {
        return data;
    }

    public T getMsg() {
        return msg;
    }
}
