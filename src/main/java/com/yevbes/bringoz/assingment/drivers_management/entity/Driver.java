package com.yevbes.bringoz.assingment.drivers_management.entity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
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

    @Column(name = "is_on_map")
    private boolean isOnMap;


    public Driver(int id, String firstName, String lastName, int age, String address, DriversStatus status,
                  LocalTime startWork, LocalTime endWork, boolean isOnMap) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.status = status;
        this.startWork = startWork;
        this.endWork = endWork;
        this.isOnMap = true;
    }

    public Driver() {
        super();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isOnMap() {
        return isOnMap;
    }

    public void setOnMap(boolean onMap) {
        isOnMap = onMap;
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
                ", isOnMap=" + isOnMap +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return id == driver.id && age == driver.age && isOnMap == driver.isOnMap
                && firstName.equals(driver.firstName) && lastName.equals(driver.lastName) && address.equals(driver.address)
                && status == driver.status && startWork.equals(driver.startWork) && endWork.equals(driver.endWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, address, status, startWork, endWork, isOnMap);
    }
}
