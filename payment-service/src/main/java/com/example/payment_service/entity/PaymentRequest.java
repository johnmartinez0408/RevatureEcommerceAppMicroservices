package com.example.payment_service.entity;

import com.example.payment_service.model.PaymentMethod;
import lombok.Data;

@Data
public class PaymentRequest {
    private Long orderId;
    private Long amount;
    private String referenceNumber;
    private String paymentMethod;
}
