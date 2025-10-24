package com.example.order_service.exception;

import lombok.Data;
@Data
public class OrderServiceException extends RuntimeException{

    private int httpStatusCode;
    private String errorCode;

    public OrderServiceException(String message, String errorCode, int httpStatusCode){
        super(message);
        this.errorCode = errorCode;
        this.httpStatusCode = httpStatusCode;
    }

}
