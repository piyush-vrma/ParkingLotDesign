package parkingspace;

import models.ParkingType;

public class HeavyVehiclePS extends BaseParkingSpace {
    private final double perHrCharge = 100;

    public HeavyVehiclePS(int parkingSpaceNumber, int floorNumber, ParkingType parkingType) {
        super(parkingSpaceNumber, floorNumber, parkingType);
    }

    @Override
    public double getPerHourCharge() {
        return perHrCharge;
    }
}
