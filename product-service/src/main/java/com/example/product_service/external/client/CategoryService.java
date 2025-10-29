package com.example.product_service.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CATEGORY-SERVICE/api/category")
public interface CategoryService {
    @GetMapping("/name/{categoryId}")
    public String getCategoryNameById(@PathVariable Long categoryId);
}
