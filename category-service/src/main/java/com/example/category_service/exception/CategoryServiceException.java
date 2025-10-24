package com.example.category_service.exception;

import lombok.Data;

@Data
public class CategoryServiceException extends RuntimeException{
    private String statusCode;

    public CategoryServiceException(String message, String statusCode){
        super(message);
        this.statusCode = statusCode;
    }
}
