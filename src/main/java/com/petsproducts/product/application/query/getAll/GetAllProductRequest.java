package com.petsproducts.product.application.query.getAll;

import com.petsproducts.common.application.mediator.Request;
import com.petsproducts.common.domain.PaginationQuery;
import com.petsproducts.product.domain.entity.ProductFilter;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetAllProductRequest implements Request<GetAllProductResponse> {
    PaginationQuery paginationQuery;

    ProductFilter productFilter;
}
