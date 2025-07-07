package gate;

import models.ParkingType;
import parkingmanager.ParkingManager;
import parkingspace.ParkingSpace;
import receipt.BookingReceipt;

import java.time.LocalDateTime;

public class EntryGate extends Gate {
    private final ParkingManager parkingManager;

    public EntryGate(int gateNumber, int floorNumber, ParkingManager parkingManager) {
        super(gateNumber, floorNumber);
        this.parkingManager = parkingManager;
    }

    public BookingReceipt getParkingSpace(Integer floorNumber, String vehicleNo, ParkingType parkingType) {
        ParkingSpace parkingSpace = parkingManager.getParkingSpace(floorNumber, parkingType);
        if (parkingSpace == null) {
            System.out.println("Parking Space full at floor: " + floorNumber + "\n");
            throw new IllegalStateException("Parking Space Not Found!");
        }

        return new BookingReceipt(
                LocalDateTime.now(),
                vehicleNo,
                this,
                parkingSpace
        );
    }

}
