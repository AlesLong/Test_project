package com.yevbes.bringoz.assingment.drivers_management.dao;

import com.yevbes.bringoz.assingment.drivers_management.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;
import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    @Query(value = "SELECT * FROM drivers WHERE STATUS = 'AVAILABLE'", nativeQuery = true)
    List<Driver> findAllAvailable();

    @Query(value = "SELECT * FROM drivers WHERE STATUS = 'DELIVERING'", nativeQuery = true)
    List<Driver> findAllDelivering();

    @Query(value = "SELECT * FROM drivers WHERE STATUS = 'UNAVAILABLE'", nativeQuery = true)
    List<Driver> findAllUnavailable();


//    @Query(value = "SELECT * FROM drivers d WHERE d.start_work_time <= :end OR d.end_work_time >= :start ", nativeQuery = true)
//    List<Driver> findDriversByTimeInterval(LocalTime start, LocalTime end);

    @Query(value = "SELECT * FROM drivers d WHERE ( d.start_work_time ,d.end_work_time) OVERLAPS (time :start,time :end) ", nativeQuery = true)
    List<Driver> findDriversByTimeInterval(LocalTime start, LocalTime end);

    @Query(value = "SELECT*FROM drivers d WHERE d.latitude <= :north AND d.latitude >= :south AND d.longitude <= :east AND d.longitude >= :west", nativeQuery = true)
    List<Driver> findAllDriversInArea(double north, double south, double east, double west);
}
