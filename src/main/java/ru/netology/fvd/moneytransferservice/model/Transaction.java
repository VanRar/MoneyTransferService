package ru.netology.fvd.moneytransferservice.model;

import java.util.Objects;

public class Transaction {
    private final Card cardFrom;
    private String cardToNumber;
    private Amount amount;

    //создаем из запроса
    public Transaction(String cardFromNumber,
                       String cardFromValidTill,
                       String cardFromCvv,
                       String cardToNumber,
                       Amount amount) {
        this.cardFrom = new Card(cardFromNumber,cardFromValidTill,cardFromCvv,amount);//по счету криво, но как есть, по другому на данном этапе нарна никак
        this.cardToNumber = cardToNumber;
        this.amount = amount;
    }

    public Card getCardFrom() {
        return cardFrom;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }

    public Amount getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "cardFrom=" + cardFrom +
                ", cardToNumber='" + cardToNumber + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return cardFrom.equals(that.cardFrom) && cardToNumber.equals(that.cardToNumber) && amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardFrom, cardToNumber, amount);
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