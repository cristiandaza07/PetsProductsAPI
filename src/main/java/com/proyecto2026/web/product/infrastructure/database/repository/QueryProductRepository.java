package com.proyecto2026.web.product.infrastructure.database.repository;

import com.proyecto2026.web.product.infrastructure.database.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryProductRepository extends JpaRepository<ProductEntity, Long> {
    
}
