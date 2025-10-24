package com.example.order_service.exception;

import lombok.Data;

public class OrderServiceException extends RuntimeException{

    private String statusCode;

    public OrderServiceException(String message, String statusCode){
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
