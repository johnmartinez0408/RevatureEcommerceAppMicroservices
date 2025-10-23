package com.example.category_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(
        name = "categories"
)
public class Category {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    Long categoryId;
    String categoryName;
    String categoryImage;
}
