package com.petsproducts.category.infrastructure.database;

import com.petsproducts.category.domain.entity.Category;
import com.petsproducts.category.domain.port.CategoryRepository;
import com.petsproducts.category.infrastructure.database.entity.CategoryEntity;
import com.petsproducts.category.infrastructure.database.mapper.CategoryEntityMapper;
import com.petsproducts.category.infrastructure.database.repository.QueryCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CategoryRepositoryImpl implements CategoryRepository {

    private final QueryCategoryRepository queryCategoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Cacheable(value = "categories", key = "#id")
    @Override
    public Optional<Category> findById(Long id) {
        return queryCategoryRepository.findById(id).map(categoryEntityMapper::mapToCategory);
    }

    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = categoryEntityMapper.mapToCategoryEntity(category);
        CategoryEntity save = queryCategoryRepository.save(categoryEntity);
        return categoryEntityMapper.mapToCategory(save);
    }

    @Override
    public Optional<Category> findByName(String nameCategory) {
        return queryCategoryRepository.findByName(nameCategory).map(categoryEntityMapper::mapToCategory);
    }

}
