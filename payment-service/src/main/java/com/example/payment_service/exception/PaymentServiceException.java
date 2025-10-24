package com.example.payment_service.exception;

public class PaymentServiceException extends RuntimeException{

    private String statusCode;

    public PaymentServiceException(String message, String statusCode){
        super(message);
        this.statusCode = statusCode;
    }

    public String getStatusCode(){
        return statusCode;
    }

    public void setStatusCode(String statusCode){
        this.statusCode = statusCode;
    }
}
