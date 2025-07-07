package parkinglot;

import floor.Floor;
import gate.EntryGate;
import gate.ExitGate;
import models.ParkingType;
import parkingspace.ParkingSpace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private final List<Floor> floors;
    private final Map<Integer, List<EntryGate>> entryGateMap;
    private final Map<Integer, List<ExitGate>> exitGateMap;

    private <T> void addGate(Map<Integer, List<T>> gateMap, Integer floor, T gate) {
        gateMap.computeIfAbsent(floor, k -> new ArrayList<>()).add(gate);
    }

    // Remove an exit gate from the list for a floor
    private <T> void removeGate(Map<Integer, List<T>> gateMap, Integer floor, T gate) {
        List<T> gates = gateMap.get(floor);
        if (gates != null) {
            gates.remove(gate);

            if (gates.isEmpty()) {
                gateMap.remove(floor);
            }
        }
    }

    public ParkingLot() {
        this.floors = new ArrayList<>();
        this.entryGateMap = new HashMap<>();
        this.exitGateMap = new HashMap<>();
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public void removeFloor(Floor floor) {
        floors.remove(floor);
    }

    public void addEntryGate(Integer floorNumber, EntryGate entryGate) {
        addGate(entryGateMap, floorNumber, entryGate);
    }

    public void removeEntryGate(Integer floorNumber, EntryGate entryGate) {
        removeGate(entryGateMap, floorNumber, entryGate);
    }

    public void addExitGate(Integer floorNumber, ExitGate exitGate) {
        addGate(exitGateMap, floorNumber, exitGate);
    }

    public void removeExitGate(Integer floorNumber, ExitGate exitGate) {
        removeGate(exitGateMap, floorNumber, exitGate);
    }

    public EntryGate getEntryGate(Integer floorNumber, Integer gateNumber) {
        List<EntryGate> gates = entryGateMap.get(floorNumber);
        if (gates != null) {
            for (EntryGate gate : gates) {
                if (gate.getGateNumber() == gateNumber)
                    return gate;
            }
        }
        return null;
    }

    public ExitGate getExitGate(Integer floorNumber, Integer gateNumber) {
        List<ExitGate> gates = exitGateMap.get(floorNumber);
        if (gates != null) {
            for (ExitGate gate : gates) {
                if (gate.getGateNumber() == gateNumber)
                    return gate;
            }
        }
        return null;
    }

    public ParkingSpace getAvailableParkingSpace(Integer floorNumber, ParkingType parkingType) {
        if (floorNumber != null) {
            ParkingSpace parkingSpace = floors.get(floorNumber).getAvailableParkingSpace(parkingType);
            if (parkingSpace != null)
                return parkingSpace;
        }

        for (Floor floor : floors) {
            // skipping earlier floor
            if (floorNumber != null && floor.getFloorNumber() == floorNumber)
                continue;

            ParkingSpace parkingSpace = floor.getAvailableParkingSpace(parkingType);
            if (parkingSpace != null)
                return parkingSpace;
        }

        return null;
    }


}
