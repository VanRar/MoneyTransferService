package ru.netology.fvd.moneytransferservice.model;

public class Operation {
    private String operationId;

    public Operation(String operationId) {
        this.operationId = operationId;
    }

    public String getOperationId() {
        return operationId;
    }
}
