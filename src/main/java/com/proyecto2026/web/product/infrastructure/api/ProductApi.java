package com.proyecto2026.web.product.infrastructure.api;

import com.proyecto2026.web.product.infrastructure.api.dto.CreateProductDto;
import com.proyecto2026.web.product.infrastructure.api.dto.ProductDto;
import com.proyecto2026.web.product.infrastructure.api.dto.UpdateProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductApi {
    ResponseEntity<List<ProductDto>> getAllProducts(@RequestParam(required = false) String pageSize);

    ResponseEntity<ProductDto> getProductById(@PathVariable Long id);

    ResponseEntity<Void> saveProduct(@RequestBody CreateProductDto createProductDto);
    
    ResponseEntity<Void> updateProduct(@RequestBody UpdateProductDto updateProductDto);

    ResponseEntity<Void> deleteProduct(@PathVariable Long id);
}
