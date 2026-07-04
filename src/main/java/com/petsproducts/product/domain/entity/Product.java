package com.petsproducts.product.domain.entity;

import com.petsproducts.category.domain.entity.Category;
import com.petsproducts.productDetail.domian.ProductDetail;
import com.petsproducts.review.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class Product {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;

    private ProductDetail productDetail;

    private List<Review> reviews;

    private List<Category> categories;

}
