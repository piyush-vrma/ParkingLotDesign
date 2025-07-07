package receipt;

import gate.EntryGate;
import parkingspace.ParkingSpace;

import java.time.LocalDateTime;

public class BookingReceipt {
    private final LocalDateTime entryTime;
    private final String vehicleNumber;
    private final EntryGate entryGate;
    private final ParkingSpace parkingSpace;

    public BookingReceipt(LocalDateTime entryTime, String vehicleNumber, EntryGate entryGate, ParkingSpace parkingSpace) {
        this.entryTime = entryTime;
        this.vehicleNumber = vehicleNumber;
        this.entryGate = entryGate;
        this.parkingSpace = parkingSpace;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public EntryGate getEntryGate() {
        return entryGate;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    @Override
    public String toString() {
        return "BookingReceipt{" +
                "entryTime=" + entryTime +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", entryGate=" + entryGate +
                ", parkingSpace=" + parkingSpace +
                '}';
    }
}
