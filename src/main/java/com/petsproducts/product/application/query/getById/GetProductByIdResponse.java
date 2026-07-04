package com.petsproducts.product.application.query.getById;

import com.petsproducts.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GetProductByIdResponse {
    private Product product;

}
