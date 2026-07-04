package com.petsproducts.product.infrastructure.database;

import com.petsproducts.common.domain.PaginationQuery;
import com.petsproducts.common.domain.PaginationResult;
import com.petsproducts.product.domain.entity.Product;
import com.petsproducts.product.domain.entity.ProductFilter;
import com.petsproducts.product.domain.port.ProductRepository;
import com.petsproducts.product.infrastructure.database.entity.ProductEntity;
import com.petsproducts.product.infrastructure.database.mapper.ProductEntityMapper;
import com.petsproducts.product.infrastructure.database.repository.QueryProductRepository;
import com.petsproducts.product.infrastructure.database.specification.ProductSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

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
    public PaginationResult<Product> findAll(PaginationQuery paginationQuery, ProductFilter productFilter) {
        PageRequest pageRequest = PageRequest.of(
                paginationQuery.getPage(),
                paginationQuery.getSize(),
                Sort.by(Sort.Direction.fromString(paginationQuery.getDirection()), paginationQuery.getSortBy())
        );

        Specification<ProductEntity> specification = Specification.allOf(
                ProductSpecification.byName(productFilter.getName())
                        .and(ProductSpecification.byDescription(productFilter.getDescription())
                                .and(ProductSpecification.byPrice(productFilter.getPriceMin(), productFilter.getPriceMax())))
        );

        Page<ProductEntity> page = productRepository.findAll(specification, pageRequest);

        return new PaginationResult<>(
                page.getContent().stream().map(productEntityMapper::mapToProduct).toList(),
                page.getNumber(),
                page.getSize(),
                page.getTotalPages(),
                page.getTotalElements()
        );
    }

    @CacheEvict(value = "products", key = "#id")
    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
