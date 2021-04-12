package com.yevbes.bringoz.assingment.drivers_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DriverGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<DriverIncorrectData> handleException(DriverException exception) {
        DriverIncorrectData data = new DriverIncorrectData(exception.getMessage());
        return new ResponseEntity<>(data, exception.getStatus());
    }


    @ExceptionHandler
    public ResponseEntity<DriverIncorrectData> handleException(Exception exception) {
        DriverIncorrectData data = new DriverIncorrectData(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
