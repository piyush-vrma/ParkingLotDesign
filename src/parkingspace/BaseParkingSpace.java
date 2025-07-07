package parkingspace;

import models.ParkingType;

public abstract class BaseParkingSpace implements ParkingSpace {
    private final int parkingSpaceNumber;
    private final int floorNumber;
    private final ParkingType parkingType;
    private boolean isEmpty;

    protected BaseParkingSpace(int parkingSpaceNumber, int floorNumber, ParkingType parkingType) {
        this.parkingSpaceNumber = parkingSpaceNumber;
        this.floorNumber = floorNumber;
        this.parkingType = parkingType;
        this.isEmpty = true;
    }

    @Override
    public int getParkingSpaceNumber() {
        return parkingSpaceNumber;
    }

    @Override
    public int getFloorNumber() {
        return floorNumber;
    }

    @Override
    public ParkingType getParkingType() {
        return parkingType;
    }

    @Override
    public boolean psIsEmpty() {
        return isEmpty;
    }

    @Override
    public void updatePsAvailability(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    @Override
    public String toString() {
        return "BaseParkingSpace{" +
                "parkingSpaceNumber=" + parkingSpaceNumber +
                ", floorNumber=" + floorNumber +
                ", parkingType=" + parkingType +
                ", isEmpty=" + isEmpty +
                '}';
    }
}
