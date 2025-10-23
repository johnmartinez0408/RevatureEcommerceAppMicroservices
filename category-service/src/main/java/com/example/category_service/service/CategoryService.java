package com.example.category_service.service;

import com.example.category_service.entity.Category;
import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long categoryId);
    Category saveCategory(Category category);
}
