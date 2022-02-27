package ru.netology.fvd.moneytransferservice.exception;

public class InputDataError extends RuntimeException{
    public InputDataError(String msg){
        super(msg);
    }
}
