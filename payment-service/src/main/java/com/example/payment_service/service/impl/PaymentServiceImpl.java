package com.example.payment_service.service.impl;

import com.example.payment_service.entity.PaymentRequest;
import com.example.payment_service.entity.TransactionDetail;
import com.example.payment_service.model.PaymentMethod;
import com.example.payment_service.repository.PaymentRepository;
import com.example.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public Long doPayment(PaymentRequest paymentRequest) {

        TransactionDetail transactionDetail = new TransactionDetail();
        transactionDetail.setOrderId(paymentRequest.getOrderId());
        transactionDetail.setPaymentMethod(PaymentMethod.valueOf(paymentRequest.getPaymentMethod()));
        transactionDetail.setAmount(paymentRequest.getAmount());
        transactionDetail.setReferenceNumber(paymentRequest.getReferenceNumber());
        transactionDetail.setPaymentDate(Instant.now());
        transactionDetail.setPaymentStatus("INITIATED");

        transactionDetail = paymentRepository.save(transactionDetail);

        return transactionDetail.getId();
    }
}
