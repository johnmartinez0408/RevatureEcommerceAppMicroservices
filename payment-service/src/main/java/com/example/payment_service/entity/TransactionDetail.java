package com.example.payment_service.entity;

import com.example.payment_service.model.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name="transaction_details"
)
public class TransactionDetail {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long orderId;

    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    @Column(nullable = false)
    private Instant paymentDate;

    @Column(nullable = false)
    private String paymentStatus;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    private String referenceNumber;
}
