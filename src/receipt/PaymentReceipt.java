package receipt;

import java.time.LocalDateTime;

public class PaymentReceipt {
    private final BookingReceipt bookingReceipt;
    private final LocalDateTime exitTime;
    private final double totalAmount;

    public PaymentReceipt(BookingReceipt bookingReceipt, LocalDateTime exitTime, double totalAmount) {
        this.bookingReceipt = bookingReceipt;
        this.exitTime = exitTime;
        this.totalAmount = totalAmount;
    }

    public BookingReceipt getBookingReceipt() {
        return bookingReceipt;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "PaymentReceipt{" +
                "bookingReceipt=" + bookingReceipt +
                ", exitTime=" + exitTime +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
