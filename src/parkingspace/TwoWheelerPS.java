package parkingspace;

import models.ParkingType;

public class TwoWheelerPS extends BaseParkingSpace {
    private final double perHrCharge = 20;

    public TwoWheelerPS(int parkingSpaceNumber, int floorNumber, ParkingType parkingType) {
        super(parkingSpaceNumber, floorNumber, parkingType);
    }

    @Override
    public double getPerHourCharge() {
        return perHrCharge;
    }
}
