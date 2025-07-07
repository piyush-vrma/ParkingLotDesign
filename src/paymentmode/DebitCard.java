package paymentmode;

public class DebitCard extends Card {
    public DebitCard(String cardNo, String cardHolderName) {
        super(cardNo, cardHolderName);
    }

    @Override
    public void pay(double farePrice) {
        System.out.println("Paid: " + farePrice + " through DebitCard");
    }
}
