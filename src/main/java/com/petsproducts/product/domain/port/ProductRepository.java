package com.petsproducts.product.domain.port;

import com.petsproducts.common.domain.PaginationQuery;
import com.petsproducts.common.domain.PaginationResult;
import com.petsproducts.product.domain.entity.Product;
import com.petsproducts.product.domain.entity.ProductFilter;

import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);

    Optional<Product> findById(Long id);

    PaginationResult<Product> findAll(PaginationQuery paginationQuery, ProductFilter productFilter);

    void deleteById(Long id);
}
