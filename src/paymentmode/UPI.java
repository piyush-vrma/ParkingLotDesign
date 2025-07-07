package paymentmode;

public class UPI implements PaymentStrategy {
    @Override
    public void pay(double farePrice) {
        System.out.println("Paid: " + farePrice + " through UPI");
    }
}
