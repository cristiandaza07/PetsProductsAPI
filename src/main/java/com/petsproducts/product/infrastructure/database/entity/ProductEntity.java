package com.petsproducts.product.infrastructure.database.entity;

import com.petsproducts.category.infrastructure.database.entity.CategoryEntity;
import com.petsproducts.productDetail.infrastructure.ProductDetailEntity;
import com.petsproducts.review.infrastructure.database.entity.ReviewEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 500)
    private String description;
    private Double price;
    private String image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_detail_id")
    private ProductDetailEntity productDetailEntity;

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL)
    private List<ReviewEntity> reviews = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "products_categories", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryEntity> categories = new ArrayList<>();

}
