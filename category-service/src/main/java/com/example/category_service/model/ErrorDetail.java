package com.example.category_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorDetail {
    private String errorMessage;
    private String errorCode;
}
