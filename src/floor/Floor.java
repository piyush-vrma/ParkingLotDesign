package floor;

import models.ParkingType;
import parkingspace.ParkingSpace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Floor {
    private final int floorNumber;
    private final Map<ParkingType, List<ParkingSpace>> parkingSpaceMap;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        parkingSpaceMap = new HashMap<>();
    }

    public void addParkingSpace(ParkingSpace parkingSpace) {
        parkingSpaceMap.computeIfAbsent(parkingSpace.getParkingType(), k -> new ArrayList<>()).add(parkingSpace);
    }

    public void removeParkingSpace(ParkingSpace parkingSpace) {
        List<ParkingSpace> parkingSpaceList = parkingSpaceMap.get(parkingSpace.getParkingType());
        if (parkingSpaceList != null) {
            parkingSpaceList.remove(parkingSpace);

            if (parkingSpaceList.isEmpty()) {
                parkingSpaceMap.remove(parkingSpace.getParkingType());
            }
        }
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public ParkingSpace getAvailableParkingSpace(ParkingType parkingType) {
        List<ParkingSpace> psList = parkingSpaceMap.get(parkingType);
        if (psList != null) {
            for (ParkingSpace ps : psList) {
                if (ps.psIsEmpty())
                    return ps;
            }
        }
        return null;
    }
}
