package com.example.order_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class OrderRequest {
    private Long productId;
    private Long quantity;
    private Long amount;
    private String paymentMethod;
}
