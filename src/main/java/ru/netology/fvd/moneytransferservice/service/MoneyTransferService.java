package ru.netology.fvd.moneytransferservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.fvd.moneytransferservice.model.Verification;
import ru.netology.fvd.moneytransferservice.model.Operation;
import ru.netology.fvd.moneytransferservice.model.Transaction;
import ru.netology.fvd.moneytransferservice.repository.MoneyTransferRepository;

//бизнес логика
@Service
public class MoneyTransferService {
    private final MoneyTransferRepository moneyTransferRepository;

    @Autowired
    public MoneyTransferService(MoneyTransferRepository moneyTransferRepository){
        this.moneyTransferRepository = moneyTransferRepository;
    }

    public Operation transfer(Transaction transaction){
        //где будет валидироваться карта и перевод
        System.out.println(transaction);


        // и фиксироваться факт проведения транзакции(деньги пока не переводятся).
        return new Operation(moneyTransferRepository.saveTransaction(transaction));
    }

    public Operation confirmOperation(Verification verification){
        return moneyTransferRepository.confirmOperation(verification);
    }
}
