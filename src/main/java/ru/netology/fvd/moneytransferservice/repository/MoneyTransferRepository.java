package ru.netology.fvd.moneytransferservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.fvd.moneytransferservice.model.Operation;
import ru.netology.fvd.moneytransferservice.model.Transaction;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.netology.fvd.moneytransferservice.model.Verification;

import java.util.HashMap;
import java.util.Map;

//работа с данными
@Repository
public class MoneyTransferRepository {
    //храним наши транзакции в мапе
    private final Map<String, Transaction> transactions = new HashMap<>();
    //сохраняем логи
    private static final Logger logger = LogManager.getLogger("transferLog");

    public String saveTransaction(Transaction transaction){
        long unixTime = System.currentTimeMillis() / 1000L;
        String time = Long.toString(unixTime);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(time)
                .append("D")
                .append(transaction.hashCode());//создаем уникальный номер
        transactions.put(stringBuilder.toString(), transaction);//сохраняем транзакцию
        logger.info("Запрос на перевод" + stringBuilder.toString() + " " + transaction);
        return stringBuilder.toString();//возвращаем уникальный номер транзакции
    }

    public Operation confirmOperation(Verification verification){
        logger.info("Перевод подтверждён " + verification.toString());
        return new Operation(verification.getOperationId());
    }

}
