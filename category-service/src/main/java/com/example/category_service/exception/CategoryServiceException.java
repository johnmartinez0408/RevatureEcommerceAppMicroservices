package com.example.category_service.exception;

import lombok.Data;

@Data
public class CategoryServiceException extends RuntimeException{
    private String statusCode;
    private int httpStatusCode;

    public CategoryServiceException(String message, String statusCode, int httpStatusCode){
        super(message);
        this.statusCode = statusCode;
        this.httpStatusCode = httpStatusCode;
    }
}
