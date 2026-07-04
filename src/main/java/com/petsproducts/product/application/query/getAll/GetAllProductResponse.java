package com.petsproducts.product.application.query.getAll;

import com.petsproducts.common.domain.PaginationResult;
import com.petsproducts.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GetAllProductResponse {
    private PaginationResult<Product> productsPage;

}
