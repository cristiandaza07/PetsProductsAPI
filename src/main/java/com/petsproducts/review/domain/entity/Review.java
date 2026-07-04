package com.petsproducts.review.domain.entity;

import com.petsproducts.product.domain.entity.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Review {
    private Long id;
    private String comment;
    private Integer score;

    private Product product;
}
