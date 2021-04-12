package com.yevbes.bringoz.assingment.drivers_management.service;

import com.yevbes.bringoz.assingment.drivers_management.dao.DriverRepository;
import com.yevbes.bringoz.assingment.drivers_management.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    @Transactional
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    @Transactional
    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    @Transactional
    public void saveDriver(Driver driver) {
        driverRepository.save(driver);
    }

    @Override
    @Transactional
    public Driver getDriver(int id) {
        Driver driver = null;
        Optional<Driver> optionalDriver = driverRepository.findById(id);
        if (optionalDriver.isPresent()) {
            driver = optionalDriver.get();
        }
        return driver;
    }

    @Override
    @Transactional
    public void deleteDriver(int id) {
        driverRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Driver> findAllAvailable() {
        return driverRepository.findAllAvailable();
    }

    @Override
    @Transactional
    public List<Driver> findAllDelivering() {
        return driverRepository.findAllDelivering();
    }

    @Override
    @Transactional
    public List<Driver> findAllUnavailable() {
        return driverRepository.findAllUnavailable();
    }

    @Override
    @Transactional
    public List<Driver> findDriversByTimeInterval(LocalTime start, LocalTime end) {
        return driverRepository.findDriversByTimeInterval(start, end);
    }

    @Override
    @Transactional
    public List<Driver> findAllDriversInArea(double north, double south, double east, double west) {
        return driverRepository.findAllDriversInArea(north, south, east, west);
    }

    @Override
    @Transactional
    public List<Driver> getDriverByFirstNameLastName(String firstName, String lastName) {
        return driverRepository.getDriverByFirstNameLastName(firstName, lastName);
    }

}
