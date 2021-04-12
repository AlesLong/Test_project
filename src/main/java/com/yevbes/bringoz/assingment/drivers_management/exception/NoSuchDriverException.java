package com.yevbes.bringoz.assingment.drivers_management.exception;

import org.springframework.http.HttpStatus;

public class NoSuchDriverException extends DriverException{
    public NoSuchDriverException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
