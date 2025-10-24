package com.example.order_service.exception;

import lombok.Data;
@Data
public class OrderServiceException extends RuntimeException{

    private int statusCode;
    private String errorCode;

    public OrderServiceException(String message, String errorCode, int statusCode){
        super(message);
        this.errorCode = errorCode;
        this.statusCode = statusCode;
    }

}
