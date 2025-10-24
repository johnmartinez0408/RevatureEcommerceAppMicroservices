package com.example.product_service.exception;

import com.example.product_service.model.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductServiceException.class)
    public ResponseEntity<ErrorDetail> handleProductServiceException(ProductServiceException ex){
        ErrorDetail errorDetail = new ErrorDetail(ex.getMessage(), ex.getStatusCode());
        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }
}
