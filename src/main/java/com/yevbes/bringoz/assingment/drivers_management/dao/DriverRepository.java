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
    //ToDo problem in type convert
    @Query(value = "SELECT * FROM drivers WHERE (start_work_time, end_work_time) OVERLAPS (?1,?2)", nativeQuery = true)
    List<Driver> findDriversByTimeInterval(LocalTime start, LocalTime end);
    //ToDo problem in syntax
    @Query(value = "SELECT * FROM drivers WHERE latitude in(?1,?2) and longitude in (?3,?4)", nativeQuery = true)
    List<Driver> findAllDriversInArea(double north, double south, double east, double west);

}
