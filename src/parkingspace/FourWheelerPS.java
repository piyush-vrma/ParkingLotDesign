package parkingspace;

import models.ParkingType;

public class FourWheelerPS extends BaseParkingSpace {
    private final double perHrCharge = 50;

    public FourWheelerPS(int parkingSpaceNumber, int floorNumber, ParkingType parkingType) {
        super(parkingSpaceNumber, floorNumber, parkingType);
    }

    @Override
    public double getPerHourCharge() {
        return perHrCharge;
    }
}
