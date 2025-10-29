package com.example.product_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private String categoryName;
    private String productName;
    private String productDescription;
    private String price;
    private Long quantity;
    private String image;
    private String brand;
}
