package ru.netology.fvd.moneytransferservice.model;

public class Verification {
    private final String operationId;
    private final String code;

    public Verification(String operationId, String code) {
        this.operationId = operationId;
        this.code = code;
    }

    public String getOperationId() {
        return operationId;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ConfirmOperation{" +
                "operationId='" + operationId + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
