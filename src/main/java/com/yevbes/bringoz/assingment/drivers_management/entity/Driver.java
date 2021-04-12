package com.yevbes.bringoz.assingment.drivers_management.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;


    @Column(name = "age", nullable = false)
    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 65, message = "Age should not be greater than 65")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private DriversStatus status;

    @Column(name = "start_work_time", columnDefinition = "time")
    private LocalTime startWork;

    @Column(name = "end_work_time", columnDefinition = "time")
    private LocalTime endWork;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;


    public Driver(String firstName, String lastName, int age, String address, DriversStatus status,
                  LocalTime startWork, LocalTime endWork) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.status = status;
        this.startWork = startWork;
        this.endWork = endWork;

    }

    public Driver() {
        super();
    }

    public Driver(int id, String firstName, String lastName, @Min(value = 18, message = "Age should not be less than 18") @Max(value = 65, message = "Age should not be greater than 65") int age, String address, DriversStatus status, LocalTime startWork, LocalTime endWork) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.status = status;
        this.startWork = startWork;
        this.endWork = endWork;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DriversStatus getStatus() {
        return status;
    }

    public void setStatus(DriversStatus status) {
        this.status = status;
    }

    public LocalTime getStartWork() {
        return startWork;
    }

    public void setStartWork(LocalTime startWork) {
        this.startWork = startWork;
    }

    public LocalTime getEndWork() {
        return endWork;
    }

    public void setEndWork(LocalTime endWork) {
        this.endWork = endWork;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", startWork=" + startWork +
                ", endWork=" + endWork +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return age == driver.age && Double.compare(driver.longitude, longitude) == 0 && Double.compare(driver.latitude, latitude) == 0 && Objects.equals(firstName, driver.firstName) && Objects.equals(lastName, driver.lastName) && Objects.equals(address, driver.address) && status == driver.status && Objects.equals(startWork, driver.startWork) && Objects.equals(endWork, driver.endWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, address, status, startWork, endWork, longitude, latitude);
    }
}
