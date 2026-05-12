package com.proyecto2026.web.product.application.query.getAll;

import com.proyecto2026.web.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class GetAllProductResponse {
    private List<Product> products;

}
