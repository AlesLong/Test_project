package com.yevbes.bringoz.assingment.drivers_management.dao;

import com.yevbes.bringoz.assingment.drivers_management.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

}
