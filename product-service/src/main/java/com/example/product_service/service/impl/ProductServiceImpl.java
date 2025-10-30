package com.example.product_service.service.impl;

import com.example.product_service.entity.Product;
import com.example.product_service.exception.ProductServiceException;
import com.example.product_service.external.client.CategoryService;
import com.example.product_service.model.ProductRequest;
import com.example.product_service.model.ProductResponse;
import com.example.product_service.repository.ProductRepository;
import com.example.product_service.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j //for logging
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Override
    public List<ProductResponse> getAllProducts() {

        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();

        products.forEach(
            product -> {
                ProductResponse currentProductResponse = new ProductResponse();
                copyProperties(product, currentProductResponse);
                String categoryName = categoryService.getCategoryNameById(product.getCategoryId());
                currentProductResponse.setCategoryName(categoryName);
                productResponses.add(currentProductResponse);
            }
        );

        return productResponses;
    }

    @Override
    public ProductResponse getProductById(Long productId) {
        Product product= productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceException("Product not found with id: " + productId, "PRODUCT_NOT_FOUND"));
        String categoryName = categoryService.getCategoryNameById(product.getCategoryId());
        ProductResponse productResponse = new ProductResponse();
        copyProperties(product, productResponse);
        productResponse.setCategoryName(categoryName);
        return productResponse;
    }

    @Override
    public ProductResponse saveProduct(ProductRequest productRequest){
//        return productRepository.save(product);
        return null;
    }

    @Override
    public List<ProductResponse> getProductsByCategory(Long categoryId) {
        String categoryName = categoryService.getCategoryNameById(categoryId);
        List<Product> products = productRepository.findByCategoryId(categoryId);
        List<ProductResponse> productResponses = products.stream()
                .map(product -> {
                    ProductResponse response = new ProductResponse();
                    copyProperties(product, response);
                    response.setCategoryName(categoryName);
                    return response;
                })
                .collect(Collectors.toList());

        return productResponses;
    }

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setQuantity(productRequest.getQuantity());

        copyProperties(productRequest, product);
        productRepository.save(product);

        ProductResponse productResponse = new ProductResponse();
        copyProperties(product, productResponse);


        return productResponse;
    }

    @Override
    public void reduceQuantity(Long productId, Long quantity) {

        Product product= productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceException("Product not found with id: " + productId, "PRODUCT_NOT_FOUND"));

        if(product.getQuantity() < quantity){
            throw new ProductServiceException("Insufficient quantity for product id: " + productId, "INSUFFICIENT_QUANTITY_AVAILABLE");
        }

        product.setQuantity(product.getQuantity() - quantity);

        productRepository.save(product);
    }
}
