package com.proyecto2026.web.product.infrastructure.database;

import com.proyecto2026.web.product.domain.entity.Product;
import com.proyecto2026.web.product.domain.port.ProductRepository;
import com.proyecto2026.web.product.infrastructure.database.entity.ProductEntity;
import com.proyecto2026.web.product.infrastructure.database.mapper.ProductEntityMapper;
import com.proyecto2026.web.product.infrastructure.database.repository.QueryProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductRepositoryImpl implements ProductRepository {

    private final QueryProductRepository productRepository;

    private final ProductEntityMapper productEntityMapper;

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productEntityMapper.mapToProductEntity(product);
        ProductEntity save = productRepository.save(productEntity);
        return productEntityMapper.mapToProduct(save);
    }

    @Cacheable(value = "products", key = "#id")
    @Override
    public Optional<Product> findById(Long id) {
        log.info("Getting product by id: {}", id);
        return productRepository.findById(id).map(productEntityMapper::mapToProduct);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll().stream().map(productEntityMapper::mapToProduct).toList();
    }

    @CacheEvict(value = "products", key = "#id")
    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
