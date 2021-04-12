package com.yevbes.bringoz.assingment.drivers_management.controller;

import com.yevbes.bringoz.assingment.drivers_management.entity.Driver;
import com.yevbes.bringoz.assingment.drivers_management.exception.DriverAlreadyExistsException;
import com.yevbes.bringoz.assingment.drivers_management.exception.NoSuchDriverException;
import com.yevbes.bringoz.assingment.drivers_management.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private DriverService driverService;

    public Controller() {
    }

    @GetMapping("/drivers")
    public List<Driver> showAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/drivers/{id}")
    public Driver getDriver(@PathVariable int id) {
        Driver driver = driverService.getDriver(id);
        if (driver == null) {
            throw new NoSuchDriverException("There is no driver with ID = " + id + " in Database");
        }
        return driver;
    }

    @PutMapping("/drivers")
    public Driver createNewDriver(@RequestBody Driver driver) {
        if (driverService.getDriverByFirstNameLastName(driver.getFirstName(), driver.getLastName()).isEmpty()) {
            driverService.saveDriver(driver);
        } else {
            throw new DriverAlreadyExistsException("Driver already exists!");
        }
        return driver;
    }

    @PostMapping("/drivers")
    public Driver updateDriver(@RequestBody Driver driver) {
        List<Driver> driverByFirstNameLastName = driverService.getDriverByFirstNameLastName(driver.getFirstName(), driver.getLastName());
        if (driverByFirstNameLastName.size() == 1) {
            Driver existingDriver = driverByFirstNameLastName.get(0);
            existingDriver.setAge(driver.getAge());
            existingDriver.setAddress(driver.getAddress());
            existingDriver.setEndWork(driver.getEndWork());
            existingDriver.setStartWork(driver.getStartWork());
            existingDriver.setLongitude(driver.getLongitude());
            existingDriver.setLatitude(driver.getLatitude());
            driverService.saveDriver(existingDriver);
        }

        return driver;
    }

    @DeleteMapping("/drivers/{id}")
    public String deleteDriver(@PathVariable int id) {
        driverService.deleteDriver(id);
        return "Driver with id: " + id + " was deleted";
    }

    @GetMapping("/drivers/status/{status}")
    public ResponseEntity<List<Driver>> getAllDriversByStatus(@PathVariable String status) {

        switch (status) {
            case "available":
                return ResponseEntity.ok(driverService.findAllAvailable());

            case "delivering":
                return ResponseEntity.ok(driverService.findAllDelivering());

            case "unavailable":
                return ResponseEntity.ok(driverService.findAllUnavailable());

            default:
                return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/drivers/location/{north}/{south}/{east}/{west}")
    public List<Driver> getDriversByLocation(@PathVariable double north, @PathVariable double south,
                                             @PathVariable double east, @PathVariable double west) {
        return driverService.findAllDriversInArea(north, south, east, west);
    }


    @GetMapping("/drivers/time/{start}/{end}")
    public List<Driver> getDriversByTimeInterval(@PathVariable @DateTimeFormat(pattern = "HH:mm:ss") LocalTime start,
                                                 @PathVariable @DateTimeFormat(pattern = "HH:mm:ss") LocalTime end) {
        return driverService.findDriversByTimeInterval(start, end);
    }
}
