package com.yevbes.bringoz.assingment.drivers_management.service;

import com.yevbes.bringoz.assingment.drivers_management.entity.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DriverService {

    public List<Driver> getAllDrivers();

    public void saveDriver(Driver driver);

    public Driver getDriver(int id);

    public void deleteDriver(int id);
}
