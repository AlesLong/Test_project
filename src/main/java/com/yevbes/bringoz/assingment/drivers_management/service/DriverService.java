package com.yevbes.bringoz.assingment.drivers_management.service;

import com.yevbes.bringoz.assingment.drivers_management.entity.Driver;

import java.time.LocalTime;
import java.util.List;

public interface DriverService {

    public List<Driver> getAllDrivers();

    public Driver createDriver(Driver driver);

    public void saveDriver(Driver driver);

    public Driver getDriver(int id);

    public void deleteDriver(int id);

    List<Driver> findAllAvailable();

    List<Driver> findAllDelivering();

    List<Driver> findAllUnavailable();

    List<Driver> findDriversByTimeInterval(LocalTime start, LocalTime end);

    List<Driver> findAllDriversInArea(double north, double south, double east, double west);

    List<Driver> getDriverByFirstNameLastName(String firstName, String lastName);

}
