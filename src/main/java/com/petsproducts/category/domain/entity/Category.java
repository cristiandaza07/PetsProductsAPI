package com.petsproducts.category.domain.entity;

import com.petsproducts.product.domain.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Category {
    private Long id;
    private String name;

    private List<Product> products;
}
