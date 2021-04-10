package com.yevbes.bringoz.assingment.drivers_management.service;

import com.yevbes.bringoz.assingment.drivers_management.dao.DriverRepository;
import com.yevbes.bringoz.assingment.drivers_management.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public List<Driver> findAllAvailable(){
        return driverRepository.findAllAvailable();
    }

    @Override
    public List<Driver> findAllDelivering() {
        return driverRepository.findAllDelivering();
    }

    @Override
    public List<Driver> findAllUnavailable() {
        return driverRepository.findAllUnavailable();
    }

}
