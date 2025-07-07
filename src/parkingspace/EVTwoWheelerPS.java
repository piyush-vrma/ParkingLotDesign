package parkingspace;

import models.ParkingType;

public class EVTwoWheelerPS extends BaseParkingSpace {
    private final double perHrCharge = 20.5;
    private final double chargingPerHrRate = 10.5;

    public EVTwoWheelerPS(int parkingSpaceNumber, int floorNumber, ParkingType parkingType) {
        super(parkingSpaceNumber, floorNumber, parkingType);
    }

    @Override
    public double getPerHourCharge() {
        return perHrCharge + chargingPerHrRate;
    }
}
