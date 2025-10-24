package com.example.payment_service.service;

import com.example.payment_service.entity.PaymentRequest;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);
}
