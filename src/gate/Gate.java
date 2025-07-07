package gate;

public abstract class Gate {
    private final int gateNumber;
    private final int floorNumber;

    protected Gate(int gateNumber, int floorNumber) {
        this.gateNumber = gateNumber;
        this.floorNumber = floorNumber;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    @Override
    public String toString() {
        return "Gate{" +
                "gateNumber=" + gateNumber +
                ", floorNumber=" + floorNumber +
                '}';
    }
}
