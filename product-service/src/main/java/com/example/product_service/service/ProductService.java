package com.example.product_service.service;

import com.example.product_service.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long productId);
    Product saveProduct(Product product);
    List<Product> getProductsByCategory(Long categoryId);
}
