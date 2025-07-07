import gate.EntryGate;
import gate.ExitGate;
import models.ParkingType;
import parkingcontroller.ParkingController;
import paymentmode.UPI;
import receipt.BookingReceipt;
import receipt.PaymentReceipt;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingController parkingController = new ParkingController();

        // Test - 1, I come to gate 1
        EntryGate entryGate = parkingController.getEntryGate(0, 2);
        if (entryGate != null) {
            System.out.println("Entering: " + entryGate + "\n");

            BookingReceipt bookingReceipt = entryGate.getParkingSpace(1, "KA-01", ParkingType.TwoWheeler);
            System.out.println("Received: " + bookingReceipt + "\n");

            // after 6 hrs
            System.out.println("Parked for 6hrs");

            Thread.sleep(6000);
            System.out.println("Leaving Parking...\n");
            ExitGate exitGate = parkingController.getExitGate(0, 1);
            if (exitGate != null) {
                System.out.println("Leaving from: " + exitGate + "\n");

                PaymentReceipt paymentReceipt = exitGate.calculateAmount(bookingReceipt);

                System.out.println("Received: " + paymentReceipt + "\n");

                exitGate.pay(paymentReceipt.getTotalAmount(), new UPI());
            } else {
                System.out.println("Exit Gate Not Found!");
            }
        } else {
            System.out.println("Entry Gate Not Found!");
        }
    }
}