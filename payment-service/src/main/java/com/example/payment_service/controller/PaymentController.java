package com.example.payment_service.controller;

import com.example.payment_service.entity.PaymentRequest;
import com.example.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/do-payment")
    public ResponseEntity<Long> getAllPayments(@RequestBody PaymentRequest paymentRequest){
        Long transactionId= paymentService.doPayment(paymentRequest);
        return new ResponseEntity(transactionId, HttpStatus.OK);
    }


}
