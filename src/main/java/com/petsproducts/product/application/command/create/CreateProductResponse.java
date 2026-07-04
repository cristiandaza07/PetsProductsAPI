package com.petsproducts.product.application.command.create;

import com.petsproducts.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateProductResponse {

    private Product product;
}
