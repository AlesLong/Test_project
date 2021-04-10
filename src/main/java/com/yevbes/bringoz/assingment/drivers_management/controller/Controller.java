package com.yevbes.bringoz.assingment.drivers_management.controller;

import com.yevbes.bringoz.assingment.drivers_management.entity.Driver;
import com.yevbes.bringoz.assingment.drivers_management.exception.NoSuchDriverException;
import com.yevbes.bringoz.assingment.drivers_management.location.Area;
import com.yevbes.bringoz.assingment.drivers_management.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

//    @GetMapping("/drivers/location/{north}/{south}/{east}/{west}")
//    public List<Driver> getDriversByLocation(@PathVariable double north, @PathVariable double south,
//                                             @PathVariable double east, @PathVariable double west) {
//        Area area = new Area(north, south, east, west);
//        return showAllDrivers().stream().filter(driver ->
//                area.isWithinEasternNorthernHemisphere(driver.getLongitude(), driver.getLatitude())
//        ).collect(Collectors.toList());
//    }

    @GetMapping("/drivers/time/{start}/{end}")
    public List<Driver> getDriversByTimeInterval(@PathVariable @DateTimeFormat(pattern = "HH:mm:ss") LocalTime start,
                                                 @PathVariable @DateTimeFormat(pattern = "HH:mm:ss") LocalTime end) {
        return driverService.findDriversByTimeInterval(start, end);
    }
}
