package com.yevbes.bringoz.assingment.drivers_management.entity;

public enum DriversStatus {
    AVAILABLE("available"),
    DELIVERING("delivering"),
    UNAVAILABLE("unavailable");

    private String status;


    DriversStatus(String status) {
        this.status = status;
    }


    public String getStatus() {
        return status;
    }

}
