package com.yevbes.bringoz.assingment.drivers_management.controller;

import com.yevbes.bringoz.assingment.drivers_management.entity.Driver;
import com.yevbes.bringoz.assingment.drivers_management.exception.NoSuchDriverException;
import com.yevbes.bringoz.assingment.drivers_management.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<Driver> allDrivers = driverService.getAllDrivers();
        return allDrivers;
    }

    @GetMapping("/drivers/{id}")
    public Driver getDriver(@PathVariable int id) {
        Driver driver = driverService.getDriver(id);
        if (driver == null) {
            throw new NoSuchDriverException("There is no driver with ID = " + id + " in Database");
        }
        return driver;
    }

    @PostMapping("/drivers")
    public Driver createNewDriver(@RequestBody Driver driver) {
        driverService.saveDriver(driver);
        return driver;
    }

    @PutMapping("/drivers")
    public Driver updateDriver(@RequestBody Driver driver) {
        driverService.saveDriver(driver);
        return driver;
    }

    @DeleteMapping("/drivers/{id}")
    public String deleteDriver(@PathVariable int id) {
        driverService.deleteDriver(id);
        return "Driver with id: " + id + " was deleted";
    }

    @GetMapping("/drivers/status/{status}")
    public ResponseEntity<List<Driver>> getAllDriversByStatus(@PathVariable("status") String status) {

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

}
