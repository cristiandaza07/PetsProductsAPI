package com.proyecto2026.web.product.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Product {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;
}
