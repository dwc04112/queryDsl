package com.example.queryDslExam.common.api_response;

import lombok.Getter;

@Getter
public class ApiResponse<T> {

    private final ApiHeader header;
    private ApiBody<T> body;

    private static final int SUCCESS = 200;

    public ApiResponse(ApiHeader header, ApiBody<T> body) {
        this.header = header;
        this.body = body;
    }

    public ApiResponse(ApiHeader header) {
        this.header = header;
    }

    public static <T> ApiResponse<T> OK(T data) {
        return new ApiResponse<T>(new ApiHeader(SUCCESS, "SUCCESS"), new ApiBody<>(data,null));
    }

    public static <T> ApiResponse<T> OK_MSG(T data, T msg) {
        return new ApiResponse<T>(new ApiHeader(SUCCESS, "SUCCESS"), new ApiBody<>(data,msg));
    }

    public static <T> ApiResponse<T> fail(ErrorCode errorCode) {
        return new ApiResponse<T>(new ApiHeader(errorCode.getCode(), errorCode.name()), new ApiBody(null, errorCode.getMessage() ));
    }
}