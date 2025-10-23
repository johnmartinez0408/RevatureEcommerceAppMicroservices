package com.example.payment_service.controller;

import com.example.payment_service.entity.Payment;
import com.example.payment_service.service.PaymentService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }

    @GetMapping(path = "/{paymentId}")
    public Payment getPaymentById(@PathVariable Long paymentId){
        return paymentService.getPaymentById(paymentId);
    }

    @PostMapping
    public Payment savePayment(@RequestBody Payment payment){
        return paymentService.savePayment(payment);
    }
}
