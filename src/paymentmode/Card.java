package paymentmode;

public abstract class Card implements PaymentStrategy {
    private String cardNo;
    private String cardHolderName;

    Card(String cardNo, String cardHolderName) {
        this.cardNo = cardNo;
        this.cardHolderName = cardHolderName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }
}
