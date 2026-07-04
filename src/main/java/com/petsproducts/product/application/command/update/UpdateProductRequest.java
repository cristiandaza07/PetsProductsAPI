package com.petsproducts.product.application.command.update;

import com.petsproducts.common.application.mediator.Request;
import com.petsproducts.review.domain.entity.Review;
import lombok.Data;

@Data
public class UpdateProductRequest implements Request<Void> {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String brand;
    private Review review;
    private Long categoryId;
}
