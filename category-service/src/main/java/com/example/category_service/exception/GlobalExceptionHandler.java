package com.example.category_service.exception;

import com.example.category_service.model.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CategoryServiceException.class)
    public ResponseEntity<ErrorDetail> handleCategoryServiceException(CategoryServiceException ex){
        ErrorDetail errorDetail = new ErrorDetail(ex.getMessage(), ex.getStatusCode());
        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }
}
