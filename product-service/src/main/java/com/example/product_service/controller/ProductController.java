package com.example.product_service.controller;

import com.example.product_service.entity.Product;
import com.example.product_service.model.ProductRequest;
import com.example.product_service.model.ProductResponse;
import com.example.product_service.service.ProductService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        List<ProductResponse> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(path = "/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long productId){
        ProductResponse productResponse =  productService.getProductById(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }


    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductResponse>> getProductsByCategory(@PathVariable Long categoryId){
        List<ProductResponse> productResponses = productService.getProductsByCategory(categoryId);
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest){
        return new ResponseEntity<>(productService.addProduct(productRequest), HttpStatus.CREATED);
    }


    //path variable comes from ?quantity=123 part of url
    @PutMapping("/reduce-quantity/{productId}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable Long productId,
                                               @RequestParam("quantity") Long quantity){
        productService.reduceQuantity(productId, quantity);

        return ResponseEntity.noContent().build();
    }
}
