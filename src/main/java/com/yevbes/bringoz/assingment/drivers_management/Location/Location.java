package com.yevbes.bringoz.assingment.drivers_management.Location;

public class Location {

    //Ukraine extreme points
    private static final double NORTH_EXTREME_POINT = 52.23;
    private static final double SOUTH_EXTREME_POINT = 44.23;
    private static final double WEST_EXTREME_POINT = 22.09;
    private static final double EAST_EXTREME_POINT = 40.13;

    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location() {
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
