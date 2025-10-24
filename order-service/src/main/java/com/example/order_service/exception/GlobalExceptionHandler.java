package com.example.order_service.exception;

import com.example.order_service.model.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(OrderServiceException.class)
    public ResponseEntity<ErrorDetail> handleOrderServiceException(OrderServiceException ex){
        ErrorDetail errorDetail = new ErrorDetail(ex.getMessage(), ex.getErrorCode(), ex.getHttpStatusCode());
        return new ResponseEntity<>(errorDetail, HttpStatusCode.valueOf(errorDetail.getHttpStatusCode()));
    }
}
