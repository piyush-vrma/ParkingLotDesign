package parkingspace;

import models.ParkingType;

public interface ParkingSpace {
    double getPerHourCharge();

    int getParkingSpaceNumber();

    int getFloorNumber();

    ParkingType getParkingType();

    boolean psIsEmpty();

    void updatePsAvailability(boolean isEmpty);
}
