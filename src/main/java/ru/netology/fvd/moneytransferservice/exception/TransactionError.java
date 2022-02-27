package ru.netology.fvd.moneytransferservice.exception;

public class TransactionError extends RuntimeException{
    public TransactionError(String msg){
        super(msg);
    }
}
