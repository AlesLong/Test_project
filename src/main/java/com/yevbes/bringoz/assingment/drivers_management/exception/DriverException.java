package com.yevbes.bringoz.assingment.drivers_management.exception;

import org.springframework.http.HttpStatus;

public class DriverException extends RuntimeException {

    private HttpStatus status;

    public DriverException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }


    public HttpStatus getStatus() {
        return status;
    }
}
