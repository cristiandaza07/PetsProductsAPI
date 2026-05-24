package com.proyecto2026.web.product.infrastructure.database;

import com.proyecto2026.web.product.domain.entity.Product;
import com.proyecto2026.web.product.domain.port.ProductRepository;
import com.proyecto2026.web.product.infrastructure.database.entity.ProductEntity;
import com.proyecto2026.web.product.infrastructure.database.mapper.ProductEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductRepositoryImpl implements ProductRepository {
    private List<ProductEntity> products = new ArrayList<>();

    private final ProductEntityMapper productEntityMapper;

    @Override
    public void save(Product product) {
        ProductEntity productEntity = productEntityMapper.mapToProductEntity(product);
        products.removeIf(p -> p.getId().equals(productEntity.getId()));
        products.add(productEntity);
    }

    @Cacheable(value = "products", key = "#id")
    @Override
    public Optional<Product> findById(Long id) {
        log.info("Getting product by id: {}", id);
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(productEntityMapper::mapToProduct);
    }

    @Override
    public List<Product> findAll() {
        return products.stream()
                .map(productEntityMapper::mapToProduct)
                .toList();
    }

    @CacheEvict(value = "products", key = "#id")
    @Override
    public void deleteById(Long id) {

        products.removeIf(p -> p.getId().equals(id));
    }
}
