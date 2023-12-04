package com.example.work1.exception;

import org.springframework.http.HttpStatus;

public class ApiRequestException extends RuntimeException {
    private final String message;
    private final HttpStatus httpStatus;

    public ApiRequestException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
