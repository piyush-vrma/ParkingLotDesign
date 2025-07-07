package gate;

import paymentmode.PaymentStrategy;
import receipt.BookingReceipt;
import receipt.PaymentReceipt;

import java.time.Duration;
import java.time.LocalDateTime;

public class ExitGate extends Gate {

    public ExitGate(int gateNumber, int floorNumber) {
        super(gateNumber, floorNumber);
    }

    public PaymentReceipt calculateAmount(BookingReceipt bookingReceipt) {
        bookingReceipt.getParkingSpace().updatePsAvailability(true);

        LocalDateTime exitTime = LocalDateTime.now();
        Duration duration = Duration.between(bookingReceipt.getEntryTime(), exitTime);

        // Simulated to hrs
        double hoursDecimal = duration.getSeconds();
        double totalAmount = bookingReceipt.getParkingSpace().getPerHourCharge() * hoursDecimal;
        return new PaymentReceipt(
                bookingReceipt,
                exitTime,
                totalAmount
        );
    }

    public void pay(double charge, PaymentStrategy paymentMode) {
        paymentMode.pay(charge);
    }
}
