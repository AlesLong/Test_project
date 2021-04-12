package com.yevbes.bringoz.assingment.drivers_management.exception;

import org.springframework.http.HttpStatus;

public class DriverAlreadyExistsException extends DriverException{

    public DriverAlreadyExistsException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
