package com.example.order_service.entity;

import com.example.order_service.model.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
    name="orders"
)
public class Order {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long orderId;
    private Long productId;
    private Long quantity;
    private Instant orderDate;
    private String orderStatus;
    private Long amount;
    private PaymentMethod paymentMethod;
}
