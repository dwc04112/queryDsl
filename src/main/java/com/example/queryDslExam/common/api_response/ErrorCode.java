package com.example.queryDslExam.common.api_response;

public enum ErrorCode {
    NOT_FOUND_USER(804, "NOT_FOUND_USER"),
    NOT_SUPPORTED_METHOD(901, "NOT_SUPPORTED_METHOD")
    ;

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}


