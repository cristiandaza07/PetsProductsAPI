package com.petsproducts.category.domain.port;

import com.petsproducts.category.domain.entity.Category;

import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findById(Long id);

    Category save(Category category);

    Optional<Category> findByName(String nameCategory);
}
