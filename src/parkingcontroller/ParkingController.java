package parkingcontroller;

import floor.Floor;
import gate.EntryGate;
import gate.ExitGate;
import models.ParkingType;
import parkinglot.ParkingLot;
import parkingmanager.ParkingManager;
import parkingspace.*;

public class ParkingController {
    private ParkingLot parkingLot;
    private ParkingManager parkingManager;

    public ParkingController() {
        init();
    }

    private void init() {
        parkingLot = new ParkingLot();
        parkingManager = new ParkingManager(parkingLot);

        /** My parkingLot will have 3 floors
         * Each floor will have 8 parkingSpaces, 2 for each type
         * 1st floor will have 2 Entry/Exit Gates
         * 2nd floor will have 1 Entry/Exit Gates
         */

        /*** Floors ***/
        for (int floorNumber = 0; floorNumber < 3; floorNumber++) {
            Floor floor = new Floor(floorNumber);
            for (int i = 1; i <= 8; i++) {
                ParkingSpace parkingSpace;
                if (i <= 2) {
                    parkingSpace = new TwoWheelerPS(i, floor.getFloorNumber(), ParkingType.TwoWheeler);
                } else if (i <= 4) {
                    parkingSpace = new FourWheelerPS(i, floor.getFloorNumber(), ParkingType.FourWheeler);
                } else if (i <= 6) {
                    parkingSpace = new HeavyVehiclePS(i, floor.getFloorNumber(), ParkingType.HeavyDuty);
                } else {
                    parkingSpace = new EVTwoWheelerPS(i, floor.getFloorNumber(), ParkingType.EVTwoWheeler);
                }
                floor.addParkingSpace(parkingSpace);
            }
            parkingLot.addFloor(floor);
        }

        /*** Entry/Exit Gates ***/
        for (int i = 1; i <= 3; i++) {
            EntryGate entryGate = new EntryGate(i, i <= 2 ? 0 : 1, parkingManager);
            parkingLot.addEntryGate(i <= 2 ? 0 : 1, entryGate);

            ExitGate exitGate = new ExitGate(i, i <= 2 ? 0 : 1);
            parkingLot.addExitGate(i <= 2 ? 0 : 1, exitGate);
        }
    }

    public EntryGate getEntryGate(Integer floorNo, Integer gateNo) {
        return parkingLot.getEntryGate(floorNo, gateNo);
    }

    public ExitGate getExitGate(Integer floorNo, Integer gateNo) {
        return parkingLot.getExitGate(floorNo, gateNo);
    }
}
