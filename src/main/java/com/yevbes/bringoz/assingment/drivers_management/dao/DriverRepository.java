package com.yevbes.bringoz.assingment.drivers_management.dao;

import com.yevbes.bringoz.assingment.drivers_management.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    @Query(value = "SELECT * FROM drivers WHERE STATUS = 'AVAILABLE'", nativeQuery = true)
    List<Driver> findAllAvailable();

    @Query(value = "SELECT * FROM drivers WHERE STATUS = 'DELIVERING'", nativeQuery = true)
    List<Driver> findAllDelivering();

    @Query(value = "SELECT * FROM drivers WHERE STATUS = 'UNAVAILABLE'", nativeQuery = true)
    List<Driver> findAllUnavailable();


}
