package com.example.product_service.service;

import com.example.product_service.entity.Product;
import com.example.product_service.model.ProductRequest;
import com.example.product_service.model.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(Long productId);
    ProductResponse addProduct(ProductRequest productRequest);

    //Currently unused
    ProductResponse saveProduct(ProductRequest productRequest);
    List<ProductResponse> getProductsByCategory(Long categoryId);

    //Important
    void reduceQuantity(Long productId, Long quantity);
}
