package ru.netology.fvd.moneytransferservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.fvd.moneytransferservice.model.Verification;
import ru.netology.fvd.moneytransferservice.model.Operation;
import ru.netology.fvd.moneytransferservice.model.Transaction;
import ru.netology.fvd.moneytransferservice.service.MoneyTransferService;

@RestController
public class MoneyTransferController {

    private final MoneyTransferService moneyTransferService;

    public MoneyTransferController(MoneyTransferService moneyTransferService) {
        this.moneyTransferService = moneyTransferService;
    }

    @PostMapping("/transfer")
    public Operation transfer(@RequestBody Transaction transaction){
        Operation sendTransaction = moneyTransferService.transfer(transaction);
        //принимает запрос на перевод денег с карты на карту
        //вызывает слой сервиса для перевода
        return sendTransaction;
    }
//ConfirmOperation - класс так называть не вариант, код не читабельный
    @PostMapping("/confirmOperation")
    public Operation confirm(@RequestBody Verification verification){
        return moneyTransferService.confirmOperation(verification);
    }



}