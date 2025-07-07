package parkingmanager;

import models.ParkingType;
import parkinglot.ParkingLot;
import parkingspace.ParkingSpace;

public class ParkingManager {
    private final ParkingLot parkingLot;

    public ParkingManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public ParkingSpace getParkingSpace(Integer floorNumber, ParkingType parkingType) {
        ParkingSpace parkingSpace;
        parkingSpace = parkingLot.getAvailableParkingSpace(floorNumber, parkingType);
        if (parkingSpace != null) {
            parkingSpace.updatePsAvailability(false);
        }
        return parkingSpace;
    }
}
