package paymentmode;

public class CreditCard extends Card {
    CreditCard(String cardNo, String cardHolderName) {
        super(cardNo, cardHolderName);
    }

    @Override
    public void pay(double farePrice) {
        System.out.println("Paid: " + farePrice + " through CreditCard");
    }
}

