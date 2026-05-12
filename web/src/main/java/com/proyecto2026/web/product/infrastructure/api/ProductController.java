package com.proyecto2026.web.product.infrastructure.api;

import com.proyecto2026.web.common.mediator.Mediator;
import com.proyecto2026.web.product.application.command.create.CreateProductRequest;
import com.proyecto2026.web.product.application.command.delete.DeleteProductRequest;
import com.proyecto2026.web.product.application.command.update.UpdateProductRequest;
import com.proyecto2026.web.product.application.query.getAll.GetAllProductRequest;
import com.proyecto2026.web.product.application.query.getAll.GetAllProductResponse;
import com.proyecto2026.web.product.application.query.getById.GetProductByIdRequest;
import com.proyecto2026.web.product.application.query.getById.GetProductByIdResponse;
import com.proyecto2026.web.product.infrastructure.api.dto.CreateProductDto;
import com.proyecto2026.web.product.infrastructure.api.dto.ProductDto;
import com.proyecto2026.web.product.infrastructure.api.dto.UpdateProductDto;
import com.proyecto2026.web.product.infrastructure.api.mapper.ProductMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController implements ProductApi {

    private final Mediator mediator;
    private final ProductMapper productMapper;

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getAllProducts(@RequestParam(required = false) String pageSize) {
        log.info("Getting all products");

        GetAllProductResponse response = mediator.dispatch(new GetAllProductRequest());

        List<ProductDto> productDtos = response.getProducts().stream().map(productMapper::mapToProductDto).toList();

        log.info("Found {} Products", productDtos.size());

        return ResponseEntity.ok(productDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        log.info("Getting product by id: {}", id);

        GetProductByIdResponse response = mediator.dispatch(new GetProductByIdRequest(id));

        ProductDto productDto = productMapper.mapToProductDto(response.getProduct());

        log.info("Found Product with id: {}", productDto);

        return ResponseEntity.ok(productDto);
    }

    @PostMapping("")
    public ResponseEntity<Void> saveProduct(@ModelAttribute @Valid CreateProductDto createProductDto) {

        log.info("Creating product with id: {}", createProductDto.getId());

        CreateProductRequest request = productMapper.mapToCreateProductRequest(createProductDto);

        mediator.dispatch(request);

        log.info("Product created with id: {}", createProductDto.getId());

        return ResponseEntity.created(URI.create("/api/v1/products/".concat(createProductDto.getId().toString()))).build();
    }

    @PutMapping("")
    public ResponseEntity<Void> updateProduct(@ModelAttribute @Valid UpdateProductDto updateProductDto) {

        log.info("Updating product with id: {}", updateProductDto.getId());

        UpdateProductRequest request = productMapper.mapToUpdateProductRequest(updateProductDto);

        mediator.dispatch(request);

        log.info("Product updated with id: {}", updateProductDto.getId());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

        log.info("Deleting product with id: {}", id);

        mediator.dispatchAsync(new DeleteProductRequest(id));

        log.info("Product deleted with id: {}", id);

        return ResponseEntity.accepted().build();
    }
}
