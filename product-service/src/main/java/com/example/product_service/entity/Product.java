package com.example.product_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name="products"
)
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long productId;
    private Long categoryId;
    private String productName;
    @Column(length = 2000)
    private String productDescription;
    private String price;
    private Long quantity;
    private String image;
    private String brand;
}
