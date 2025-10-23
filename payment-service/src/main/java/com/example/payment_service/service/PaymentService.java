package com.example.payment_service.service;

import com.example.payment_service.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();
    Payment getPaymentById(Long paymentId);
    Payment savePayment(Payment payment);
}
