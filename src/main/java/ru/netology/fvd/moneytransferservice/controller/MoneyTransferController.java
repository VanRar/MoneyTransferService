package ru.netology.fvd.moneytransferservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.fvd.moneytransferservice.model.Verification;
import ru.netology.fvd.moneytransferservice.model.Operation;
import ru.netology.fvd.moneytransferservice.model.Transaction;
import ru.netology.fvd.moneytransferservice.service.MoneyTransferService;

/**
 * @RestController — говорит спрингу, что данный класс является REST контроллером.
 * Т.е. в данном классе будет реализована логика обработки клиентских запросов
 */
@RestController
public class MoneyTransferController {

    /**
     * "MoneyTransferService сервис перевода денег, в нём реализована бизнес логика по переводу
     */
    private final MoneyTransferService moneyTransferService;

    /**
     * @Autowired — говорит спрингу, что в этом месте необходимо внедрить зависимость.
     *  * В конструктор мы передаем MoneyTransferService. Реализация данного сервиса
     *  * помечена аннотацией @Service, и спринг сможет передать экземпляр этой
     *  * реализации в конструктор контроллера.
     * @param moneyTransferService
     */
    @Autowired
    public MoneyTransferController(MoneyTransferService moneyTransferService) {
        this.moneyTransferService = moneyTransferService;
    }

    /**
     * Эндпоинты: /transfer - принимает объект с данными формы /confirmOperation - принимает объект с айди операции и секретным кодом
     * создадим POJO-объект Transaction из запроса
     * возвращать будем строку с кодом операции, обернем её в класс
     */
    @PostMapping("/transfer")
    public Operation transfer(@RequestBody Transaction transaction){
        return moneyTransferService.transfer(transaction);
    }
//ConfirmOperation - класс так называть не вариант, код не читабельный
    public Operation confirm(@RequestBody Verification verification){
        return moneyTransferService.confirmOperation(verification);
    }





}