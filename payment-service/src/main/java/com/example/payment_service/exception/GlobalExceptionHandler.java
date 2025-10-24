package com.example.payment_service.exception;

import com.example.payment_service.model.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PaymentServiceException.class)
    public ResponseEntity<ErrorDetail> handlePaymentServiceException(PaymentServiceException ex){
        ErrorDetail errorDetail = new ErrorDetail(ex.getMessage(), ex.getStatusCode());
        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }
}
