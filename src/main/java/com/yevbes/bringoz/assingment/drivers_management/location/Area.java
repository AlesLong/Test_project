package com.yevbes.bringoz.assingment.drivers_management.location;

public class Area {
    private double northExtremePoint;
    private double southExtremePoint;
    private double westExtremePoint;
    private double eastExtremePoint;

    public Area(double northExtremePoint, double southExtremePoint,
                double eastExtremePoint, double westExtremePoint) {
        this.northExtremePoint = northExtremePoint;
        this.southExtremePoint = southExtremePoint;
        this.westExtremePoint = westExtremePoint;
        this.eastExtremePoint = eastExtremePoint;
    }

    public boolean isWithinEasternNorthernHemisphere(double longitude, double latitude) {
        return longitude < eastExtremePoint && longitude > westExtremePoint
                && latitude > southExtremePoint && latitude < northExtremePoint;
    }
}
