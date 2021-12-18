package ru.netology.fvd.moneytransferservice.model;

import java.util.Objects;

public class Card {
    private String cardNumber;
    private String cardValidTill;
    private String cardCvv;
    private Amount amount;

    public Card(String cardNumber, String cardValidTill, String cardCvv, Amount amount) {
        this.cardNumber = cardNumber;
        this.cardValidTill = cardValidTill;
        this.cardCvv = cardCvv;
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardValidTill() {
        return cardValidTill;
    }

    public void setCardValidTill(String cardValidTill) {
        this.cardValidTill = cardValidTill;
    }

    public String getCardCvv() {
        return cardCvv;
    }

    public void setCardCvv(String cardCvv) {
        this.cardCvv = cardCvv;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardNumber.equals(card.cardNumber) && cardValidTill.equals(card.cardValidTill) && cardCvv.equals(card.cardCvv) && amount.equals(card.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, cardValidTill, cardCvv, amount);
    }
}
//{"cardFromNumber": "1231323123132131",
//"cardToNumber": "5456465465465465",
//"cardFromCVV": "111",
//"cardFromValidTill": "06/23",
//"amount": {
//"currency": "RUR",
//"value": 12300}
//}